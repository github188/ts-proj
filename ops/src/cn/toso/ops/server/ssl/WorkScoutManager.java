package cn.toso.ops.server.ssl;

import java.util.List;
import java.util.Vector;

import org.apache.log4j.Logger;

import EDU.oswego.cs.dl.util.concurrent.PooledExecutor;

public class WorkScoutManager {

	/**
	 * 数据监测者数目
	 */
	int scoutCount = 2;

	/**
	 * 每个监测者监控的连接的最多数目
	 */
	int maxSize = 100;

	/**
	 * 允许读写空闲的时间
	 */
	long freeTimeAllowed = 5 * 60 * 1000;// 5分钟

	/**
	 * 线程执行器
	 */
	PooledExecutor executor;

	/**
	 * 监测者列表
	 */
	List workScoutList;

	/**
	 * 数据处理派发者
	 */
	WorkDispatcher dispatcher;

	/**
	 * 数据监测者
	 */
	private WorkScout scout;

	Logger logger;

	/**
	 * 构造方法
	 * 
	 * @param dispatcher
	 *            数据处理派发者
	 */
	public WorkScoutManager(WorkDispatcher dispatcher, int scoutCount,
			int maxSize, long freeTimeAllowed) {
		this.dispatcher = dispatcher;
		this.scoutCount = scoutCount;
		this.maxSize = maxSize;
		this.freeTimeAllowed = freeTimeAllowed;

		logger = Logger.getLogger(this.getClass());
	}

	/**
	 * 开始监测
	 */
	public void startScout() {
		this.workScoutList = new Vector(scoutCount);

		for (int i = 0; i < scoutCount; i++) {
			scout = new WorkScout(this.dispatcher, maxSize, freeTimeAllowed);
			this.workScoutList.add(scout);
		}
		executor = new PooledExecutor(scoutCount);

		for (int i = 0; i < workScoutList.size(); i++) {
			scout = (WorkScout) workScoutList.get(i);
			try {
				executor.execute(scout);
			} catch (InterruptedException e) {
				logger.error("executor.execute() Error", e);
			}
		}
	}

	/**
	 * 停止监测
	 */
	public void stopScout() {
		for (int i = 0; i < workScoutList.size(); i++) {
			scout = (WorkScout) workScoutList.get(i);
			scout.stop();
		}
		executor.shutdownAfterProcessingCurrentlyQueuedTasks();
	}

	/**
	 * 添加被监测对象
	 * 
	 * @param exchangeInfo
	 *            被监测对象
	 */
	public void addExchangeInfo(ExchangeInfo exchangeInfo) {
		int size;
		int minSize = Integer.MAX_VALUE;
		int minIndex = -1;

		// 对数据监测者列表中的所有监测者,取得监测数目最少的监测者
		for (int i = 0; i < workScoutList.size(); i++) {
			scout = (WorkScout) workScoutList.get(i);
			size = scout.size();
			if (size < minSize) {
				minSize = size;
				minIndex = i;
			}
		}

		scout = (WorkScout) workScoutList.get(minIndex);

		// 将被监测对象,交由查到的监测者执行
		scout.addExchangeInfo(exchangeInfo);
		// System.out.println("TIME ADD TO SCOUT\t"+System.currentTimeMillis());
	}

	/**
	 * @return 所有被监测的连接数目
	 */
	public int getExchangeInfoSize() {
		int res = 0;
		for (int i = 0; i < workScoutList.size(); i++) {
			scout = (WorkScout) workScoutList.get(i);
			res += scout.size();
		}
		return res;
	}

	/**
	 * 
	 * @return 是否超出允许监测的数目
	 */
	public boolean isOverflow() {
		if (getExchangeInfoSize() >= scoutCount * maxSize) {
			return true;
		} else {
			return false;
		}
	}
}
