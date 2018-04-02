package zgame.net.netty.Server;

import java.net.InetSocketAddress;
import java.util.Properties;

/**
 * @author zhangzhou
 * @date 2018-03-08 网络配置
 */
public class NetWorkConfig {

	public final InetSocketAddress ADDRESS;

	public NetWorkConfig(Properties properties) {
		String inetHost = properties.getProperty("ip");
		int inetPort = Integer.valueOf(properties.getProperty("port"));
		ADDRESS = new InetSocketAddress(inetHost, inetPort);
	}

	public InetSocketAddress getADDRESS() {
		return ADDRESS;
	}

}
