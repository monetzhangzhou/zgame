package zgame.net.netty.Server.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author zhangzhou
 * @date 2018-04-02 消息解码
 */
public class GameDecodeHandler extends ChannelInboundHandlerAdapter {

	private static final int MAX_LENGTH = 2048;

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

		ctx.fireChannelRead(msg);
	}

}
