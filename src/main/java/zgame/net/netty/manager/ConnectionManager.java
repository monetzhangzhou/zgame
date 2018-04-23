package zgame.net.netty.manager;
/** 
 * @author zhangzhou
 * @date 2018-01-03
 * 
 */

import java.util.concurrent.ConcurrentHashMap;

import zgame.net.netty.Server.Connection;

public class ConnectionManager {

	private static ConcurrentHashMap<Object, Connection> connectionMap = new ConcurrentHashMap<Object, Connection>();

	public static Connection getConnection(Object id) {
		return connectionMap.get(id);
	}

	public static Connection addConnection(Object id, Connection connection) {
		if (connectionMap.containsKey(id)) {
			return getConnection(id);
		}
		return connectionMap.put(id, connection);
	}

	public static void onDisconnect(Connection conn) {
		connectionMap.remove(conn.getId());
	}
}
