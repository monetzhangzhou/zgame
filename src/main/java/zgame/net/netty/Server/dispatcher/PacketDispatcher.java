package zgame.net.netty.Server.dispatcher;

import zgame.net.message.BasePacket;

public abstract class PacketDispatcher {

	public abstract <T extends BasePacket> void dispatch(T packet);
}
