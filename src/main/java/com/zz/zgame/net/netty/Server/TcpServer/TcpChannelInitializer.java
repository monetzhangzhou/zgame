package com.zz.zgame.net.netty.Server.TcpServer;

import com.zz.zgame.net.netty.Server.AbstractServer;
import com.zz.zgame.net.netty.Server.handler.ServerHandler;
import com.zz.zgame.net.netty.Server.handler.TcpDecodeHandler;
import com.zz.zgame.net.netty.Server.handler.TcpEncodeHandler;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

/**
 * @author zhangzhou
 * @date 2018-03-08
 * 
 */
public class TcpChannelInitializer extends ChannelInitializer<SocketChannel> {
	private final AbstractServer server;

	public TcpChannelInitializer(AbstractServer server) {
		this.server = server;
	}

	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		ch.pipeline().addLast("decoder", new TcpDecodeHandler()).addLast("server-handler", new ServerHandler<>(server))
				.addLast("encoder", new TcpEncodeHandler());

	}

}
