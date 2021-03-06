package com.zz.zgame.net.message;

import com.zz.zgame.net.netty.Server.Connection;

/**
 * tcp协议消息包
 * 
 * @author zhangzhou
 * @date 2018-04-02
 * 
 */
public abstract class AbstractTcpPacket extends BasePacket {

	private Connection connection;

	protected AbstractTcpPacket(int protocol, byte[] bytes) {
		super(protocol, bytes);
	}

	public Connection getConnection() {
		return connection;
	}

	@Override
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

}
