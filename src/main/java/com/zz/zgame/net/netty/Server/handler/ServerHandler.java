package com.zz.zgame.net.netty.Server.handler;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.zz.zgame.net.message.BasePacket;
import com.zz.zgame.net.netty.Server.AbstractServer;
import com.zz.zgame.net.netty.Server.Connection;
import com.zz.zgame.net.netty.manager.ConnectionManager;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Tcp协议通用的Handler
 *
 * Created by zhangzhou on 16/12/2.
 */
public class ServerHandler<T extends BasePacket> extends ChannelInboundHandlerAdapter {
	private static Log log = LogFactory.getLog(ServerHandler.class);
	private final AbstractServer server;

	public ServerHandler(AbstractServer server) {
		this.server = server;
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		super.channelActive(ctx);
		if (log.isDebugEnabled())
			log.debug("[" + ctx.channel().remoteAddress() + "] connected");
		Connection connection = new Connection(server.getNetWorkConfig().getFirst_timeout_sec(),
				server.getNetWorkConfig().getRead_write_timeout_sec(), ctx.channel());
		ConnectionManager.addConnection(ctx.channel(), connection);
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		super.channelInactive(ctx);
		if (log.isDebugEnabled())
			log.debug("[" + ctx.channel().remoteAddress() + "] disconnected");
		Connection conn = ConnectionManager.getConnection(ctx.channel());
		if (conn != null)
			ConnectionManager.onDisconnect(conn);
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		@SuppressWarnings("unchecked")
		T packet = (T) msg;
		Connection conn = ConnectionManager.getConnection(ctx.channel());
		if (conn != null) {
			packet.setConnection(conn);
			conn.markReadOrWriteTimestamp();
		}
		server.receivePacket(packet);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		log.error("handle packet from [" + ctx.channel().id().asLongText() + "] failed!", cause);
		Connection conn = ConnectionManager.getConnection(ctx.channel());
		if (conn != null) {
			conn.close();
		} else {
			log.error("connection[" + ctx.channel().id().asLongText() + "] not found in manager");
			ctx.channel().close();
		}
	}
}
