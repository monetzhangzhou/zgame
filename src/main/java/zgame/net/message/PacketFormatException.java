package zgame.net.message;

/**
 * @author zhangzhou
 *
 */
public class PacketFormatException extends Exception {

	private static final long serialVersionUID = -5657134983503067648L;

	public PacketFormatException(String message) {
		super(message);
	}

	public PacketFormatException() {
	}
}
