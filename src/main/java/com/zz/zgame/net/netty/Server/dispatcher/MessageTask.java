package com.zz.zgame.net.netty.Server.dispatcher;

import com.zz.zgame.net.message.BasePacket;
import com.zz.zgame.net.netty.manager.MessageManager;

public class MessageTask implements Runnable {
	private final BasePacket packet;
	protected final MessageManager handlerManager;

	public MessageTask(BasePacket packet, MessageManager handlerManager) {
		this.packet = packet;
		this.handlerManager = handlerManager;
	}

	public void run() {
		try {
			handlerManager.forward(packet);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
