package zgame.net.netty.Server;

import java.net.InetSocketAddress;
import java.util.Properties;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelOption;

/**
 * @author zhangzhou
 * @date 2018-03-08 网络配置
 */
public class NetWorkConfig {
	private int so_backlog = 128;
	private boolean tcp_nodelay = true;
	private boolean so_reuseaddr = true;
	private boolean so_keepalive = true;
	private boolean http_compression = false;
	private boolean websocket_compression = false;
	private String ip = "127.0.0.1";
	private int port = 33211;
	private int io_threads = Runtime.getRuntime().availableProcessors();
	private int min_logic_threads = 2 * io_threads;
	private int max_logic_threads = 4 * io_threads;
	private int logic_threads_keep_alive = 180;
	private int read_write_timeout_sec = 300;
	private int first_timeout_sec = 20;

	public final InetSocketAddress ADDRESS;

	public NetWorkConfig(Properties properties) {
		this.init(properties);
		String inetHost = properties.getProperty("ip");
		int inetPort = Integer.valueOf(properties.getProperty("port"));
		ADDRESS = new InetSocketAddress(inetHost, inetPort);
	}

	public InetSocketAddress getADDRESS() {
		return ADDRESS;
	}

	public int getRead_write_timeout_sec() {
		return read_write_timeout_sec;
	}

	public int getFirst_timeout_sec() {
		return first_timeout_sec;
	}

	public int getSo_backlog() {
		return so_backlog;
	}

	public boolean isTcp_nodelay() {
		return tcp_nodelay;
	}

	public boolean isSo_reuseaddr() {
		return so_reuseaddr;
	}

	public boolean isSo_keepalive() {
		return so_keepalive;
	}

	public boolean isHttp_compression() {
		return http_compression;
	}

	public String getIp() {
		return ip;
	}

	public int getPort() {
		return port;
	}

	public int getIo_threads() {
		return io_threads;
	}

	public int getMin_logic_threads() {
		return min_logic_threads;
	}

	public int getMax_logic_threads() {
		return max_logic_threads;
	}

	public boolean isWebsocket_compression() {
		return websocket_compression;
	}

	public int getLogic_threads_keep_alive() {
		return logic_threads_keep_alive;
	}

	public void init(Properties properties) {
		if (properties.containsKey("so_backlog"))
			so_backlog = Integer.valueOf(properties.getProperty("so_backlog"));
		if (properties.containsKey("tcp_nodelay"))
			tcp_nodelay = Boolean.valueOf(properties.getProperty("tcp_nodelay"));
		if (properties.containsKey("so_reuseaddr"))
			tcp_nodelay = Boolean.valueOf(properties.getProperty("so_reuseaddr"));
		if (properties.containsKey("so_keepalive"))
			tcp_nodelay = Boolean.valueOf(properties.getProperty("so_keepalive"));
		if (properties.containsKey("http_compression"))
			tcp_nodelay = Boolean.valueOf(properties.getProperty("http_compression"));
		if (properties.containsKey("ip"))
			ip = properties.getProperty("ip");
		if (properties.containsKey("port"))
			port = Integer.valueOf(properties.getProperty("port"));
		if (properties.containsKey("io_threads"))
			io_threads = Integer.valueOf(properties.getProperty("io_threads"));
		if (properties.containsKey("min_logic_threads"))
			min_logic_threads = Integer.valueOf(properties.getProperty("min_logic_threads"));
		if (properties.containsKey("max_logic_threads"))
			max_logic_threads = Integer.valueOf(properties.getProperty("max_logic_threads"));
		if (properties.containsKey("http_compression"))
			http_compression = Boolean.valueOf(properties.getProperty("http_compression"));
		if (properties.containsKey("websocket_compression"))
			websocket_compression = Boolean.valueOf(properties.getProperty("websocket_compression"));
		if (properties.containsKey("logic_threads_keep_alive"))
			logic_threads_keep_alive = Integer.valueOf(properties.getProperty("logic_threads_keep_alive"));
		if (properties.containsKey("read_write_timeout_sec"))
			read_write_timeout_sec = Integer.valueOf(properties.getProperty("read_write_timeout_sec"));
		if (properties.containsKey("first_timeout_sec"))
			first_timeout_sec = Integer.valueOf(properties.getProperty("first_timeout_sec"));
	}

	public void apply(ServerBootstrap b) {
		b.option(ChannelOption.SO_BACKLOG, so_backlog);
		b.option(ChannelOption.TCP_NODELAY, tcp_nodelay);
		b.option(ChannelOption.SO_REUSEADDR, so_reuseaddr);
		b.childOption(ChannelOption.SO_KEEPALIVE, so_keepalive);
	}

	public void apply(Bootstrap b) {
		b.option(ChannelOption.TCP_NODELAY, tcp_nodelay);
		b.option(ChannelOption.SO_REUSEADDR, so_reuseaddr);
	}

}
