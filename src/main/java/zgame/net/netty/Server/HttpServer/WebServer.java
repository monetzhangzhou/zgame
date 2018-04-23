package zgame.net.netty.Server.HttpServer;

import java.util.Properties;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import zgame.net.message.BasePacket;
import zgame.net.netty.Server.AbstractServer;
import zgame.net.netty.Server.dispatcher.PacketDispatcher;
import zgame.net.netty.Server.dispatcher.WebMessageDispatcher;

/**
 * Web服务器
 * 
 * @author zhangzhou 2018年4月23日
 *
 */
public class WebServer extends AbstractServer {
	protected ChannelInitializer<SocketChannel> initializer;
	private final PacketDispatcher dispatcher = new WebMessageDispatcher();

	public WebServer(Properties netWorkProperties) {
		super(netWorkProperties);
	}

	@Override
	public <T extends BasePacket> void receivePacket(T packet) {
		this.dispatcher.dispatch(packet);
	}

	@Override
	protected void setInitializer() {
		this.initializer = new WebChannelInitializer(this);
	}

	@Override
	public void shutdown() throws Exception {

	}

	@Override
	public void start() {
		// TODO Auto-generated method stub

	}

}