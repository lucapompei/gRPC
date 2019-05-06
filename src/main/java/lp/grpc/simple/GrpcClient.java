package lp.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lp.grpc.contants.ServerConstants;
import lp.grpc.proto.helloService.HelloRequest;
import lp.grpc.proto.helloService.HelloResponse;
import lp.grpc.proto.helloService.HelloServiceGrpc;

/**
 * The gRPC client
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
	 */
	public HelloResponse getHello(String firstName, String lastName) {

		// Get the channel to query the server available at localhost:8080
		ManagedChannel channel = ManagedChannelBuilder
				.forAddress(ServerConstants.SERVER_NAME, ServerConstants.SERVER_PORT)
				.usePlaintext()
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
