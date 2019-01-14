package com.zz.zgame.net.netty.Server;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

import com.zz.zgame.net.message.BasePacket;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;

/**
 * @author zhangzhou
 * @date 2018-01-02 socket连接
 */
public class Connection {
	private final Channel channel;
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

	private int threadId;

	public Connection(int firstIdle, int idle, Channel channel) {
		this.channel = channel;
		this.firstIdle = firstIdle;
		this.idle = idle;
		this.lastReadOrWriteTime.set(System.currentTimeMillis());
		this.id = channel;
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

	public int getThreadId() {
		return threadId;
	}

	public void setThreadId(int threadId) {
		this.threadId = threadId;
	}

	public void markReadOrWriteTimestamp() {
		this.lastReadOrWriteTime.set(System.currentTimeMillis());
	}

	public boolean isActive() {
		return channel != null && channel.isActive();
	}

	public void close() {
		if (channel != null && channel.isActive()) {
			channel.close();
		}
	}

	protected void _writeAndFlush(BasePacket packet) {
		if (channel != null && channel.isActive())
			channel.writeAndFlush(packet);
	}

	public void closeAfterWriteAndFlush(BasePacket packet) {
		if (channel != null && channel.isActive()) {
			ChannelFuture future = channel.writeAndFlush(packet);
			future.addListener(new ChannelFutureListener() {
				@Override
				public void operationComplete(ChannelFuture future) throws Exception {
					future.channel().close();
				}
			});
		}
	}
}
