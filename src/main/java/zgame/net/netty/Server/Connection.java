package zgame.net.netty.Server;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author zhangzhou
 * @date 2018-01-02 socket连接
 */
public class Connection {
	// 是否被锁住使用状态
	private AtomicBoolean lock = new AtomicBoolean();
	// 最近一次读socket的时间或者最近一次写socket的时间
	private AtomicLong lastReadOrWriteTime = new AtomicLong();
	// 标识
	private Object id;
	// socket最近一次断的时间戳
	private AtomicLong disConnectTime = new AtomicLong();
	private final int firstIdle;
	private final int idle;

	public Connection(int firstIdle, int idle, Object id) {
		this.firstIdle = firstIdle;
		this.idle = idle;
		this.lastReadOrWriteTime.set(System.currentTimeMillis());
		this.id = id;
	}

	public AtomicBoolean getLock() {
		return lock;
	}

	public void setLock(AtomicBoolean lock) {
		this.lock = lock;
	}

	public AtomicLong getLastReadOrWriteTime() {
		return lastReadOrWriteTime;
	}

	public void setLastReadOrWriteTime(AtomicLong lastReadOrWriteTime) {
		this.lastReadOrWriteTime = lastReadOrWriteTime;
	}

	public Object getId() {
		return id;
	}

	public void setId(Object id) {
		this.id = id;
	}

	public AtomicLong getDisConnectTime() {
		return disConnectTime;
	}

	public void setDisConnectTime(AtomicLong disConnectTime) {
		this.disConnectTime = disConnectTime;
	}

	public int getFirstIdle() {
		return firstIdle;
	}

	public int getIdle() {
		return idle;
	}

}
