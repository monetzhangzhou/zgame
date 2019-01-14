package com.zz.zgame.net.message;

/**
 * upd 协议消息包
 * 
 * @author zhangzhou
 * @date 2018-04-02
 * 
 */
public abstract class AbstractUdpPacket extends BasePacket {

	protected AbstractUdpPacket(int protocol, byte[] bytes) {
		super(protocol, bytes);
	}

}
