package zgame.net.netty.Server.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import zgame.net.message.BasePacket;
import zgame.net.message.MessagePacket;

/**
 * Tcp编码器
 * 
 * @author zhangzhou 2018年4月23日
 */
public class TcpEncodeHandler extends ChannelOutboundHandlerAdapter {
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
				ctx.writeAndFlush(buf);
				return;
			} finally {
				buf.release();
			}
		}
		super.write(ctx, msg, promise);
	}
}
