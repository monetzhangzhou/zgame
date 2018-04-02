package zgame.net.netty.manager;
/** 
 * @author zhangzhou
 * @date 2018-01-03
 * 
 */

import java.util.concurrent.ConcurrentHashMap;

import zgame.net.netty.Server.Connection;

public class ConnectionManager {

	private ConcurrentHashMap<Object, Connection> connectionMap = new ConcurrentHashMap<Object, Connection>();

	public Connection getConnection(Object id) {
		return this.connectionMap.get(id);
	}

	public Connection addConnection(Object id, Connection connection) {
		return this.connectionMap.put(id, connection);
	}
}
