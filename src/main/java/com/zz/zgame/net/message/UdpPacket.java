package com.zz.zgame.net.message;

import java.net.InetSocketAddress;

import com.zz.zgame.net.netty.Server.Connection;

/**
 * udp消息包
 * 
 * @author zhangzhou
 * @date 2018-04-02
 * 
 */
public class UdpPacket extends AbstractUdpPacket {

	private InetSocketAddress clientAddr;

	protected UdpPacket(int protocol, byte[] bytes) {
		super(protocol, bytes);
	}

	public InetSocketAddress getClientAddr() {
		return clientAddr;
	}

	public void setClientAddr(InetSocketAddress clientAddr) {
		this.clientAddr = clientAddr;
	}

	@Override
	public void setConnection(Connection connection) {
		// TODO Auto-generated method stub

	}

	@Override
	public Connection getConnection() {
		// TODO Auto-generated method stub
		return null;
	}

}
