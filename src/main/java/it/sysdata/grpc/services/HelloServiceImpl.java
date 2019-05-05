package it.sysdata.grpc.services;

import io.grpc.stub.StreamObserver;
import it.sysdata.grpc.proto.helloService.HelloRequest;
import it.sysdata.grpc.proto.helloService.HelloResponse;
import it.sysdata.grpc.proto.helloService.HelloServiceGrpc.HelloServiceImplBase;

/**
 * The service used to handle "hello" operations
 * 
 * @author lucapompei
 *
 */
public class HelloServiceImpl extends HelloServiceImplBase {



	/**
	 * Override the hello gRPC method
	 * 
	 * @param request, the incoming gRPC request
	 * @param responseObserver, the observer used to send a gRPC response
	 */
	@Override
	public void hello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {

		// Define new greeting from request
		String greeting = new StringBuilder()
				.append("Hello, ")
				.append(request.getFirstName())
				.append(" ")
				.append(request.getLastName())
				.toString();

		// Build response
		HelloResponse response = HelloResponse.newBuilder()
				.setGreeting(greeting)
				.build();

		// Send response to observer
		responseObserver.onNext(response);
		responseObserver.onCompleted();

	}

}
