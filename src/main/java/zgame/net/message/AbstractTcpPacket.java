package zgame.net.message;

import zgame.net.netty.Server.Connection;

/**
 * tcp协议消息包
 * 
 * @author zhangzhou
 * @date 2018-04-02
 * 
 */
public abstract class AbstractTcpPacket extends BasePacket {

	private Connection connection;

	protected AbstractTcpPacket(byte[] bytes) {
		super(bytes);
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

}
