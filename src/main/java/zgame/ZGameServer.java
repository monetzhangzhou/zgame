package zgame;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import zgame.net.netty.Server.TcpServer.TcpServer;

/**
 * @author zhangzhou
 * @date 2018-01-02
 * 
 */
public class ZGameServer {

	public static void main(String[] args) throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		TcpServer tcpServer = applicationContext.getBean(TcpServer.class);
		tcpServer.start();
		System.err.println(" server start ");
	}

}
