package cn.toso.ops.server.ssl;

import java.io.IOException;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Vector;

import org.apache.log4j.Logger;

import EDU.oswego.cs.dl.util.concurrent.Mutex;
import EDU.oswego.cs.dl.util.concurrent.Sync;

public class WorkScout implements Runnable {

	/**
	 * 被监测对象列表
	 */
	List exchangeInfoList;

	/**
	 * 数据处理派发者
	 */
	WorkDispatcher dispatcher;

	/**
	 * 被监测对象的最大数目
	 */
	int maxSize;

	/**
	 * 独占锁,防止本类所在线程与WorkScoutManager所在线程访问冲突
	 */
	Sync busyLock;

	/**
	 * 允许读写空闲的时间
	 */
	long freeTimeAllowed;

	/**
	 * 停止监测
	 */
	boolean nowStop;

	Logger logger;

	/**
	 * 构造函数
	 * 
	 * @param dispatcher
	 *            数据处理派发者
	 * @param maxSize
	 *            被监测对象的最大数目
	 */
	public WorkScout(WorkDispatcher dispatcher, int maxSize,
			long freeTimeAllowed) {
		this.dispatcher = dispatcher;
		this.maxSize = maxSize;
		this.freeTimeAllowed = freeTimeAllowed;
		exchangeInfoList = new Vector();
		busyLock = new Mutex();

		logger = Logger.getLogger(this.getClass());
	}

	/**
	 * 添加被监测者到队列
	 * 
	 * @param ei
	 *            被监测者
	 */
	public void addExchangeInfo(ExchangeInfo ei) {
		// need get lock
		try {
			busyLock.acquire();
			ei.setLastAccessTime(System.currentTimeMillis());
			exchangeInfoList.add(ei);
		} catch (InterruptedException e) {
			logger.error("addExchangeInfo() acquire busyLock Error", e);
		} finally {
			busyLock.release();
		}
	}

	/**
	 * 被监测对象队列大小
	 * 
	 * @return 被监测对象队列大小
	 */
	public int size() {
		int res = 0;
		try {
			busyLock.acquire();
			res = exchangeInfoList.size();
		} catch (InterruptedException e) {
			logger.error("size() acquire busyLock Error", e);
		} finally {
			busyLock.release();
		}
		return res;
	}

	/**
	 * 停止监测
	 */
	public void stop() {
		try {
			busyLock.acquire();
			nowStop = true;
		} catch (InterruptedException e) {
			logger.error("stop() acquire busyLock Error", e);
		} finally {
			busyLock.release();
		}
	}

	/**
	 * 监测方法
	 */
	public void run() {
		// 循环
		nowStop = false;
		while (true) {
			// 当监测队列时,监测队列返回false,退出监测,停止线程.
			if (!scout()) {
				break;
			}
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				logger.error("run() sleep Error", e);
			}
		}
	}

	/**
	 * 监测队列。 返回false之前，释放持有的信息
	 * 
	 * @return 当监测某个对象时,返回false时,返回false；否则,返回true
	 */
	boolean scout() {
		ExchangeInfo exchangeInfo;
		Socket socket;
		int res;
		for (int i = 0; i < exchangeInfoList.size(); i++) {
			exchangeInfo = (ExchangeInfo) exchangeInfoList.get(i);

			socket = exchangeInfo.getSocket();

			// 检测连接状态，若未绑定、未连接、关闭、输入流关闭或输出流关闭，则移除此连接
			// System.out.println("isClosed:" + socket.isClosed());
			if (socket.isClosed() || !socket.isConnected() || !socket.isBound()
					|| socket.isInputShutdown() || socket.isOutputShutdown()) {
				exchangeInfoList.remove(i);
				i--;
				continue;
			}
			// System.out.println("TIME SCOUT
			// BGN\t"+System.currentTimeMillis());
			res = scoutOne(exchangeInfo);
			// System.out.println("TIME SCOUT
			// END\t"+System.currentTimeMillis());
			if (res == -1) {
				releaseInfo();
				return false;
			}
			if (res == 1) {
				try {
					socket.close();
				} catch (IOException e) {
					logger.error("scout() close socket Error", e);
				}
				exchangeInfoList.remove(i);
				i--;
			}
		}
		return true;
	}

	/**
	 * 监测某个对象
	 * 
	 * @param exchangeInfo
	 *            被监测对象
	 * @return 当遇到停止标志为真,不监测,返回-1；当检测很久没有读写时，返回1；否则,执行监测,返回0
	 */
	int scoutOne(ExchangeInfo exchangeInfo) {
		try {
			busyLock.acquire();
			if (nowStop) {
				return -1;
			}

			// 检测是否很久没有读写
			long now = System.currentTimeMillis();
			if (now - exchangeInfo.getLastAccessTime() > freeTimeAllowed) {
				return 1;
			}

			// 若ExchangeInfo空闲，尝试读数
			if (exchangeInfo.isFree()) {

				ByteBuffer rBuf = ByteBuffer.allocate(1);
				byte[] bBuf;
				int res;
				// System.out.println("TIME SCOUT BGN
				// READ\t"+System.currentTimeMillis());
				res = exchangeInfo.getReadChannel().read(rBuf);
				if (res == -1) {
					// 若读数错误
					return 1;
				}
				// System.out.println("TIME SCOUT END
				// READ\t"+System.currentTimeMillis());
				// 若读到数，转发给Dispatcher
				if (res > 0) {
					// 读到数了
					rBuf.flip();
					bBuf = rBuf.array();
					if (logger.isDebugEnabled()) {
						logger.debug("Received one char ["
								+ new String(bBuf, 0, res) + "] from client"
								+ exchangeInfo.getSocket().getInetAddress());
					}
					exchangeInfo.append(bBuf);
					exchangeInfo.setLastAccessTime(now);
					exchangeInfo.setFree(false);
					// exchangeInfo.getReadLock().acquire();
					// dispatch
					// System.out.println("TIME ADD TO
					// DISPATCHER\t"+System.currentTimeMillis());
					dispatcher.dispatch(exchangeInfo);
				}
			}
		} catch (InterruptedException e) {
			logger.error("scoutOne() acquire busyLock Error", e);
		} catch (IOException e) {
			logger.error("scoutOne() readData Error", e);
		} finally {
			busyLock.release();
		}
		return 0;
	}

	void releaseInfo() {

	}
}
