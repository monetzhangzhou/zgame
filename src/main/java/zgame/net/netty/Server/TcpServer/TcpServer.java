package zgame.net.netty.Server.TcpServer;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import zgame.net.message.BasePacket;
import zgame.net.netty.Server.AbstractServer;
import zgame.net.netty.Server.dispatcher.MessagePacketDispatcher;

/**
 * @author zhangzhou
 * @date 2018-01-02
 * 
 */
public class TcpServer extends AbstractServer {
	@Autowired
	private MessagePacketDispatcher packetDispatcher;

	protected ChannelInitializer<SocketChannel> initializer;

	public TcpServer(Properties netWorkProperties) {
		super(netWorkProperties);
	}

	public void start() throws Exception {
		ServerBootstrap bootstrap = new ServerBootstrap();
		bootstrap.group(bossGroup, workerGroup);
		bootstrap.channel(NioServerSocketChannel.class);
		bootstrap.option(ChannelOption.SO_BACKLOG, 128);
		bootstrap.option(ChannelOption.TCP_NODELAY, true);
		bootstrap.option(ChannelOption.SO_REUSEADDR, true);
		bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
		bootstrap.childHandler(initializer);
		bootstrap.bind(netWorkConfig.getADDRESS()).sync();
		packetDispatcher.init();
	}

	public void shutdown() throws Exception {
		bossGroup.shutdownGracefully().sync();
		workerGroup.shutdownGracefully().sync();
	}

	@Override
	public <T extends BasePacket> void receivePacket(T packet) {
		packetDispatcher.dispatch(packet);
	}

	@Override
	protected void setInitializer() {
		initializer = new TcpChannelInitializer(this);

	}

}
