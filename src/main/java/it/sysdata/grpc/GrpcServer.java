package it.sysdata.grpc;

import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import it.sysdata.grpc.contants.ServerConstants;
import it.sysdata.grpc.services.HelloServiceImpl;

/**
 * The gRPC server
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

		// Define a new server at port 8080
		// Adding a proto based service
		Server server = ServerBuilder
				.forPort(ServerConstants.SERVER_PORT)
				.addService(new HelloServiceImpl()).build();

		// Start the server
		server.start();

		// Set termination strategy
		if (awaitTermination) {
			server.awaitTermination();
		}

	}

}
