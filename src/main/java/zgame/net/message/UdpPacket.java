package zgame.net.message;

import java.net.InetSocketAddress;

/**
 * udp消息包
 * 
 * @author zhangzhou
 * @date 2018-04-02
 * 
 */
public class UdpPacket extends AbstractUdpPacket {

	private InetSocketAddress clientAddr;

	protected UdpPacket(byte[] bytes) {
		super(bytes);
	}

	public InetSocketAddress getClientAddr() {
		return clientAddr;
	}

	public void setClientAddr(InetSocketAddress clientAddr) {
		this.clientAddr = clientAddr;
	}

}
