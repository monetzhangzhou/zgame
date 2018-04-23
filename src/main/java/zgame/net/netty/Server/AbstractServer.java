package zgame.net.netty.Server;

import java.util.Properties;

import io.netty.channel.nio.NioEventLoopGroup;
import zgame.net.message.BasePacket;

/**
 * @author zhangzhou
 * @date 2018-01-02
 */
public abstract class AbstractServer {
	private int bossThread = Runtime.getRuntime().availableProcessors() / 2 + 1;
	private int workerThread = Runtime.getRuntime().availableProcessors();
	protected NioEventLoopGroup bossGroup;
	protected NioEventLoopGroup workerGroup;

	protected NetWorkConfig netWorkConfig;

	public AbstractServer(Properties netWorkProperties) {
		bossGroup = new NioEventLoopGroup(bossThread);
		workerGroup = new NioEventLoopGroup(workerThread);
		netWorkConfig = new NetWorkConfig(netWorkProperties);
		setInitializer();

	}

	public abstract void start() throws InterruptedException, Exception;

	public abstract void shutdown() throws Exception;

	public NetWorkConfig getNetWorkConfig() {
		return netWorkConfig;
	}

	public abstract <T extends BasePacket> void receivePacket(T packet);

	protected abstract void setInitializer();

}
