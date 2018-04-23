package zgame.net.message;

/**
 * @author zhangzhou
 * @date 2018-01-04
 * 
 */
public class MessagePacket extends AbstractTcpPacket {

	public MessagePacket(int protocol, byte[] bytes) {
		super(protocol, bytes);
	}

}
