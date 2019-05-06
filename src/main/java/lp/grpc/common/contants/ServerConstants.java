package lp.grpc.common.contants;

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
	 * The server port for TLS purpose
	 */
	public static final int SERVER_PORT_TLS = 8443;



	/**
	 * The certificate chain filename
	 */
	public static final String CERT_CHAIN_FILENAME = "cert/cert.pem";



	/**
	 * The certificate private key
	 */
	public static final String PRIVATE_KEY_FILENAME = "cert/key.pem";



	/**
	 * Private constructor for an utility class
	 */
	private ServerConstants() {
		throw new IllegalAccessError(CommonConstants.STANDARD_MESSAGE_UTILITY_CLASS);
	}
}
