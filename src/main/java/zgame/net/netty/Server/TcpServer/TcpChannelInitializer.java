package zgame.net.netty.Server.TcpServer;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

/**
 * @author zhangzhou
 * @date 2018-03-08
 * 
 */
public class TcpChannelInitializer extends ChannelInitializer<SocketChannel> {

	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		// ch.pipeline().addLast(handlers);

	}

}
