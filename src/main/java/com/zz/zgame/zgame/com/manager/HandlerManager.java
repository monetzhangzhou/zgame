package com.zz.zgame.zgame.com.manager;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

import com.zz.zgame.net.message.BasePacket;
import com.zz.zgame.net.message.MessagePacket;
import com.zz.zgame.net.netty.manager.MessageManager;

@Component
public class HandlerManager implements MessageManager {

	private ConcurrentHashMap<Integer, IHandler> protocolMap = new ConcurrentHashMap<>();

	public void refresh() {
		protocolMap.clear();
	}

	@Override
	public void forward(BasePacket packet) {
		MessagePacket messagePacket = (MessagePacket) packet;
		IHandler t = protocolMap.get(packet.getProtocol());
		if (null == t) {
			return;
		}
		t.execute(messagePacket);
	}

	public void register(int protocol, IHandler hanler) {
		protocolMap.put(protocol, hanler);
	}
}
