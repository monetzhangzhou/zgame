package zgame.net.netty.Server;

import java.util.Properties;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author zhangzhou
 * @date 2018-01-02
 */
public abstract class AbstractServer {
	private int bossThread = Runtime.getRuntime().availableProcessors() / 2 + 1;
	private int workerThread = Runtime.getRuntime().availableProcessors();
	private NioEventLoopGroup bossGroup = new NioEventLoopGroup(bossThread);
	private NioEventLoopGroup workerGroup = new NioEventLoopGroup(workerThread);

	protected ChannelInitializer<SocketChannel> initializer;

	private NetWorkConfig netWorkConfig;

	public AbstractServer(ChannelHandler childHandler, Properties netWorkProperties) {
		netWorkConfig = new NetWorkConfig(netWorkProperties);

	}

	public void start() {
		ServerBootstrap bootstrap = new ServerBootstrap();
		bootstrap.group(bossGroup, workerGroup);
		bootstrap.channel(NioServerSocketChannel.class);
		bootstrap.option(ChannelOption.SO_BACKLOG, 128);
		bootstrap.option(ChannelOption.TCP_NODELAY, true);
		bootstrap.option(ChannelOption.SO_REUSEADDR, true);
		bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
		// bootstrap.childHandler(childHandler);
		// bootstrap.bind(netWorkConfig.getADDRESS()).sync();
	}

	public void shutdown() throws Exception {
		bossGroup.shutdownGracefully().sync();
		workerGroup.shutdownGracefully().sync();
	}

}
