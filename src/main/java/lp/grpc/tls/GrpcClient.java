package lp.grpc.tls;

import java.io.File;

import javax.net.ssl.SSLException;

import io.grpc.ManagedChannel;
import io.grpc.netty.GrpcSslContexts;
import io.grpc.netty.NettyChannelBuilder;
import lp.grpc.common.contants.ServerConstants;
import lp.grpc.common.proto.helloService.HelloRequest;
import lp.grpc.common.proto.helloService.HelloResponse;
import lp.grpc.common.proto.helloService.HelloServiceGrpc;

/**
 * The gRPC client that support TLS
 * 
 * @author lucapompei
 *
 */
public class GrpcClient {



	/**
	 * Get hello from gRPC server
	 * 
	 * @param firstName, the first name to use for the hello request
	 * @param lastName, the last name to use for the hello request
	 * @return the hello response from the gRPC server
	 * @throws SSLException
	 */
	public HelloResponse getHello(String firstName, String lastName) throws SSLException {

		// Get certificate data
		File certChainFile = new File(
				GrpcServer.class.getClassLoader().getResource(ServerConstants.CERT_CHAIN_FILENAME).getFile());

		// Get the channel to query the server available at localhost:8443
		ManagedChannel channel = NettyChannelBuilder
				.forAddress(ServerConstants.SERVER_NAME, ServerConstants.SERVER_PORT_TLS)
				.sslContext(
						GrpcSslContexts.forClient().trustManager(certChainFile).build())
				.build();

		// Creates a new blocking-style stub based on the channel created above
		HelloServiceGrpc.HelloServiceBlockingStub stub = HelloServiceGrpc.newBlockingStub(channel);

		// Define the hello request
		HelloRequest request = HelloRequest.newBuilder()
				.setFirstName(firstName)
				.setLastName(lastName)
				.build();

		// Using the stub above, query the server
		HelloResponse helloResponse = stub.hello(request);

		// Close the channel
		channel.shutdown();

		// Return the received response
		return helloResponse;

	}

}
