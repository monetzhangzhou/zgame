package com.zz.zgame.net.netty.Server.dispatcher;

import com.zz.zgame.net.message.BasePacket;

public abstract class PacketDispatcher {

	public abstract <T extends BasePacket> void dispatch(T packet);
}
