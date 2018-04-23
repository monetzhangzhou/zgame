package zgame.zgame;

import java.util.Properties;

import zgame.net.netty.Server.TcpServer.TcpServer;

/**
 * @author zhangzhou
 * @date 2018-01-03
 * 
 */
public class GameServer extends TcpServer {

	public GameServer(Properties netWorkProperties) {
		super(netWorkProperties);
	}

}
