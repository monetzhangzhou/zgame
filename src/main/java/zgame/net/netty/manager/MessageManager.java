package zgame.net.netty.manager;

import zgame.net.message.BasePacket;

/**
 * @author zhangzhou
 * @date 2018-01-04
 * 
 */
public interface MessageManager {

	void forward(BasePacket packet);
}
