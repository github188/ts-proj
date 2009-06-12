package cn.toso.ops.server.ssl;

import org.apache.log4j.Logger;

import cn.toso.ops.server.control.ControlPool;
import cn.toso.ops.util.PacketParser;

import EDU.oswego.cs.dl.util.concurrent.PooledExecutor;

public class WorkDispatcher {

	PooledExecutor executor;

	PacketParser parser;

	ControlPool controlPool;

	Logger logger;

	public WorkDispatcher(PacketParser parser, int maxSize, int minSize,
			long keepAliveTime, ControlPool controlPool) {
		this.executor = new PooledExecutor();
		executor.setMaximumPoolSize(maxSize);
		executor.setMinimumPoolSize(minSize);
		executor.setKeepAliveTime(keepAliveTime);
		this.parser = parser;
		this.controlPool = controlPool;
		logger = Logger.getLogger(this.getClass());
	}

	synchronized public void dispatch(ExchangeInfo exchangeInfo) {
		WorkRunnable worker = new WorkRunnable(exchangeInfo, parser,
				controlPool);

		try {
			executor.execute(worker);
		} catch (InterruptedException e) {
			exchangeInfo.setFree(true);
			logger.error("executor.execute() Error", e);
		}
	}

	public void stopDispatch() {
		executor.shutdownAfterProcessingCurrentlyQueuedTasks();
	}
}
