package com.zz.zgame.net.message;

import com.zz.zgame.net.netty.Server.Connection;

/**
 * @author zhangzhou
 * @date 2018-04-02 消息基类
 */
public abstract class BasePacket {
	/* 头 */
	public static final byte HEAD = 0x7c;

	/* 内容 */
	private final byte[] bytes;
	/* 协议号 */
	private final int protocol;

	protected BasePacket(int protocol, byte[] bytes) {
		this.protocol = protocol;
		this.bytes = bytes;
	}

	public byte[] getBytes() {
		return bytes;
	}

	public int getProtocol() {
		return protocol;
	}

	public abstract void setConnection(Connection connection);

	public abstract Connection getConnection();
}
