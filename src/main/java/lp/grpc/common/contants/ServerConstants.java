package lp.grpc.contants;

/**
 * Utility class that expose server contants
 * 
 * @author lucapompei
 *
 */
public class ServerConstants {



	/**
	 * The server name
	 */
	public static final String SERVER_NAME = "localhost";



	/**
	 * The server port
	 */
	public static final int SERVER_PORT = 8080;



	/**
	 * Private constructor for an utility class
	 */
	private ServerConstants() {
		throw new IllegalAccessError(CommonConstants.STANDARD_MESSAGE_UTILITY_CLASS);
	}
}
