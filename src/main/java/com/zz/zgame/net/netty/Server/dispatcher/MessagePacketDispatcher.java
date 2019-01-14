package com.zz.zgame.net.netty.Server.dispatcher;

import java.util.concurrent.ExecutorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zz.zgame.net.message.BasePacket;
import com.zz.zgame.net.netty.Server.dispatcher.executor.ExecutorManager;
import com.zz.zgame.net.netty.manager.MessageManager;
import com.zz.zgame.net.netty.manager.SessionManager;

@Component
public class MessagePacketDispatcher extends PacketDispatcher {

	@Autowired
	private ExecutorManager executorManager;

	@Autowired
	private SessionManager sessionManager;

	@Autowired
	private MessageManager messageManager;

	public void init() {
		executorManager.init();
	}

	@Override
	public <T extends BasePacket> void dispatch(T packet) {
		long playerId = sessionManager.getPlayerId(packet.getConnection());
		int threadId = 0;
		if (0 < playerId) {
			threadId = packet.getConnection().getThreadId();
		}
		ExecutorService executor = executorManager.getExecutorService(threadId);
		executor.execute(new MessageTask(packet, messageManager));
	}

}
