package zgame.net.netty.Server.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import zgame.net.message.BasePacket;
import zgame.net.message.MessagePacket;
import zgame.net.message.PacketFormatException;

/**
 * Tcp解码器
 * 
 * @author zhangzhou 2018年4月23日
 *
 */
public class TcpDecodeHandler extends ChannelInboundHandlerAdapter {
	private static final int MAX_LENGTH = 2048;

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		if (msg instanceof ByteBuf) {
			ByteBuf in = (ByteBuf) msg;
			// if (in.readableBytes() < BasePacket.BODY_EXCEPT_BYTE_LENGTH)
			// return; TODO
			if (in.readByte() != BasePacket.HEAD)
				throw new PacketFormatException();
			short cmd = in.readShort();
			short bodySize = in.readShort();
			if (bodySize < 0 || bodySize > MAX_LENGTH)
				throw new PacketFormatException();
			if (in.readableBytes() < bodySize)
				throw new PacketFormatException();
			byte[] bytes = new byte[bodySize];
			in.readBytes(bytes);
			ctx.fireChannelRead(new MessagePacket(cmd, bytes));
			in.release();
			return;
		}
	}
}
