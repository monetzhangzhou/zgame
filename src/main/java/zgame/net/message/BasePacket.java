package zgame.net.message;

/**
 * @author zhangzhou
 * @date 2018-04-02 消息基类
 */
public class BasePacket {
	/* 头 */
	public static final byte HEAD = 0x7c;

	/* 内容 */
	private final byte[] bytes;

	protected BasePacket(byte[] bytes) {
		this.bytes = bytes;
	}

	public byte[] getBytes() {
		return bytes;
	}

}
