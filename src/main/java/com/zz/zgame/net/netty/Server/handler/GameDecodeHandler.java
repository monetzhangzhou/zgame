package com.zz.zgame.net.netty.Server.handler;

import com.zz.zgame.net.message.BasePacket;
import com.zz.zgame.net.message.MessagePacket;
import com.zz.zgame.net.message.PacketFormatException;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;

/**
 * @author zhangzhou
 * @date 2018-04-02 消息解码
 */
public class GameDecodeHandler extends ChannelInboundHandlerAdapter {

	private static final int MAX_LENGTH = 2048;

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		if (msg instanceof BinaryWebSocketFrame) {
			ByteBuf in = ((BinaryWebSocketFrame) msg).content();
			if (in.readableBytes() < 5)
				throw new PacketFormatException();
			if (in.readByte() != BasePacket.HEAD)
				throw new PacketFormatException();
			short length = in.readShort();
			if (length <= 0 || length > MAX_LENGTH)
				throw new PacketFormatException();
			short cmd = in.readShort();
			if (in.readableBytes() < length - 2)
				throw new PacketFormatException();
			byte[] bytes = new byte[length - 2];
			in.readBytes(bytes);
			ctx.fireChannelRead(new MessagePacket(cmd, bytes));
			in.release();
			return;
		}
		ctx.fireChannelRead(msg);
	}

}
