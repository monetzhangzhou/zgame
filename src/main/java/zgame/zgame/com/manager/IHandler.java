package zgame.zgame.com.manager;

import zgame.net.message.MessagePacket;

public interface IHandler {

	void execute(MessagePacket packet);
}
