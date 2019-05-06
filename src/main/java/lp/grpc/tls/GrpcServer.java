package lp.grpc.tls;

import java.io.File;
import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import lp.grpc.common.contants.ServerConstants;
import lp.grpc.common.services.HelloServiceImpl;

/**
 * The gRPC server that support TLS
 * 
 * @author lucapompei
 *
 */
public class GrpcServer {



	/**
	 * Start a new gRPC start
	 * 
	 * @param args
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
		// Start the gPRC server
		GrpcServer.start();
	}



	/**
	 * Start a new gRPC server
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static void start() throws IOException, InterruptedException {
		// As default, start the server blocking its shutdown after the startup
		start(true);
	}



	/**
	 * Start a new gRPC server
	 * 
	 * @param awaitTermination, a boolean that indicate whether the server should
	 *        shut down after startup
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static void start(boolean awaitTermination) throws IOException, InterruptedException {

		// Get certificate data
		File certChainFile = new File(
				GrpcServer.class.getClassLoader().getResource(ServerConstants.CERT_CHAIN_FILENAME).getFile());
		File privateKeyFile = new File(
				GrpcServer.class.getClassLoader().getResource(ServerConstants.PRIVATE_KEY_FILENAME).getFile());

		// Define a new server at port 8443 enabling TLS
		// Adding a proto based service
		Server server = ServerBuilder
				.forPort(ServerConstants.SERVER_PORT_TLS)
				// Enable TLS
				.useTransportSecurity(certChainFile, privateKeyFile)
				.addService(new HelloServiceImpl())
				.build();

		// Start the server
		server.start();

		// Set termination strategy
		if (awaitTermination) {
			server.awaitTermination();
		}

	}

}
