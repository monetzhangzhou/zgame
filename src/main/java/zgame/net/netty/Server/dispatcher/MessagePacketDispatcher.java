package zgame.net.netty.Server.dispatcher;

import java.util.concurrent.ExecutorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import zgame.net.message.BasePacket;
import zgame.net.netty.Server.dispatcher.executor.ExecutorManager;
import zgame.net.netty.manager.MessageManager;
import zgame.net.netty.manager.SessionManager;

@Component
public class MessagePacketDispatcher extends PacketDispatcher {

	@Autowired
	private ExecutorManager executorManager;

	@Autowired
	private SessionManager sessionManager;

	@Autowired
	private MessageManager messageManager;

	public void init() {
		executorManager.init();
	}

	@Override
	public <T extends BasePacket> void dispatch(T packet) {
		long playerId = sessionManager.getPlayerId(packet.getConnection());
		int threadId = 0;
		if (0 < playerId) {
			threadId = packet.getConnection().getThreadId();
		}
		ExecutorService executor = executorManager.getExecutorService(threadId);
		executor.execute(new MessageTask(packet, messageManager));
	}

}
