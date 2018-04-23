package zgame.net.netty.Server.HttpServer;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import zgame.net.netty.Server.handler.GameDecodeHandler;
import zgame.net.netty.Server.handler.GameEncodeHandler;
import zgame.net.netty.Server.handler.ServerHandler;

public class WebChannelInitializer extends ChannelInitializer<SocketChannel> {
	WebServer server;

	public WebChannelInitializer(WebServer webServer) {
		this.server = webServer;
	}

	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		ch.pipeline().addLast("http-codec", new HttpServerCodec());
		ch.pipeline().addLast("aggregator", new HttpObjectAggregator(65536));
		ch.pipeline().addLast("websocket", new WebSocketServerProtocolHandler("/", null, true));
		ch.pipeline().addLast("index-page", new WebIndexPageHandler("/"));
		ch.pipeline().addLast("frame-decoder", new GameDecodeHandler());
		ch.pipeline().addLast("server-handler", new ServerHandler<>(server));
		ch.pipeline().addLast("frame-encoder", new GameEncodeHandler());

	}
}
