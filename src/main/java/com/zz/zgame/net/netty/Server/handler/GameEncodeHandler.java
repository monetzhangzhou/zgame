package com.zz.zgame.net.netty.Server.handler;

import com.zz.zgame.net.message.BasePacket;
import com.zz.zgame.net.message.MessagePacket;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;

/**
 * @author zhangzhou
 * @date 2018-04-02 消息编码
 */
public class GameEncodeHandler extends ChannelOutboundHandlerAdapter {
	@Override
	public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
		if (msg instanceof MessagePacket) {
			MessagePacket packet = (MessagePacket) msg;
			ByteBuf buf = ctx.alloc().buffer(5 + packet.getBytes().length);
			try {
				buf.writeByte(BasePacket.HEAD);
				buf.writeInt(packet.getProtocol());
				buf.writeShort(packet.getBytes().length);
				buf.writeBytes(packet.getBytes());
				BinaryWebSocketFrame frame = new BinaryWebSocketFrame(buf);
				ctx.writeAndFlush(frame);
				return;
			} finally {
				buf.release();
			}
		}
		ctx.writeAndFlush(msg);
	}
}
