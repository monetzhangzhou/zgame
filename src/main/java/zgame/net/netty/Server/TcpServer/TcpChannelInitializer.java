package zgame.net.netty.Server.TcpServer;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import zgame.net.netty.Server.AbstractServer;
import zgame.net.netty.Server.handler.ServerHandler;
import zgame.net.netty.Server.handler.TcpDecodeHandler;
import zgame.net.netty.Server.handler.TcpEncodeHandler;

/**
 * @author zhangzhou
 * @date 2018-03-08
 * 
 */
public class TcpChannelInitializer extends ChannelInitializer<SocketChannel> {
	private final AbstractServer server;

	public TcpChannelInitializer(AbstractServer server) {
		this.server = server;
	}

	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		ch.pipeline().addLast("decoder", new TcpDecodeHandler()).addLast("server-handler", new ServerHandler<>(server))
				.addLast("encoder", new TcpEncodeHandler());

	}

}
