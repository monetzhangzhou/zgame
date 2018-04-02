package zgame.net.netty.manager;
/** 
 * @author zhangzhou
 * @date 2018-01-08
 * 
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicLong;

public class SessionManager {

	public static AtomicLong connectCount = new AtomicLong();

	long playerId;

	ExecutorService executorService;

	public void receiveMessage() {

	}
}
