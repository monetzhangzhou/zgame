package zgame.net.netty.manager;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Component;

import zgame.net.netty.Server.Connection;

/**
 * @author zhangzhou
 * @date 2018-01-08
 * 
 */
@Component
public class SessionManager {

	public static AtomicLong connectCount = new AtomicLong();

	private ConcurrentMap<Connection, Long> c2p = new ConcurrentHashMap<>();
	private ConcurrentMap<Long, Connection> p2c = new ConcurrentHashMap<>();

	public void onConnect(Connection conn) {
	}

	public void onDisconnect(Connection conn) {
		Long playerId = c2p.get(conn);
		if (playerId == null)
			return;
		Connection key = p2c.remove(playerId);
		if (key != null) {
			c2p.remove(key);
		}

	}

	/**
	 * 玩家是否在线
	 * 
	 * @param playerId
	 * @return
	 */
	public boolean isOnLine(long playerId) {
		Connection connection = p2c.get(playerId);
		if (connection != null && connection.isActive()) {
			return true;
		}
		return false;
	}

	/**
	 * 踢玩家下线
	 * 
	 * @param playerId
	 */
	public void kickOffLine(long playerId) {
		Connection connection = p2c.get(playerId);
		if (connection == null || !connection.isActive()) {
			return;
		}
		connection.close();
		onDisconnect(connection);
	}

	/**
	 * 添加玩家连接
	 * 
	 * @param playerId
	 * @param conn
	 */
	public void add(long playerId, Connection conn) {
		c2p.put(conn, playerId);
		p2c.put(playerId, conn);
	}

	/**
	 * 根据PlayerId获取连接
	 * 
	 * @param playerId
	 * @return
	 */
	public Connection getConn(long playerId) {
		return p2c.get(playerId);
	}

	/**
	 * 根据Connection获取PlayerId
	 * 
	 * @param conn
	 * @return
	 */
	public long getPlayerId(Connection conn) {
		Long playerId = c2p.get(conn);
		if (playerId == null) {
			return -1;
		}
		return playerId;
	}

	/**
	 * 获取所有在线的connection
	 * 
	 * @return
	 */
	public Collection<Connection> getOnLineConnections() {
		return p2c.values();
	}

	/**
	 * 获取所有在线玩家
	 * 
	 * @return
	 */
	public Collection<Long> getOnlinePlayers() {
		return p2c.keySet();
	}

	public void receiveMessage() {

	}
}
