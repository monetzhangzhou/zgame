package com.zz.zgame.net.netty.Server.dispatcher.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.stereotype.Component;

/**
 * @author zhangzhou 2018年4月24日 线程池管理器
 */
@Component
public class ExecutorManager {
	public static final int threadCount = Runtime.getRuntime().availableProcessors();
	private ExecutorService[] executorServiceArray = new ExecutorService[threadCount];

	public void init() {
		for (int i = 0; i < threadCount; i++) {
			ExecutorService executorService = Executors.newSingleThreadExecutor(new NamedThreadFactory());
			executorServiceArray[i] = executorService;
		}
	}

	public ExecutorService getExecutorService(int diff) {
		return executorServiceArray[diff];

	}
}
