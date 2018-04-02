package zgame.zgame;

import io.netty.channel.ChannelHandler;
import zgame.net.netty.Server.TcpServer.TcpServer;

/**
 * @author zhangzhou
 * @date 2018-01-03
 * 
 */
public class GameServer extends TcpServer {

	public GameServer(ChannelHandler childHandler, String inetHost, int inetPort) {
		super(childHandler, inetHost, inetPort);
		// TODO Auto-generated constructor stub
	}

}
