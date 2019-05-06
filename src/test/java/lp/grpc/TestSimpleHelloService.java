package lp.grpc;

import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lp.grpc.GrpcClient;
import lp.grpc.GrpcServer;
import lp.grpc.proto.helloService.HelloResponse;

/**
 * Test class prepared for testing the gRPC HelloService service
 * 
 * @author lucapompei
 *
 */
public class TestHelloService {



	/**
	 * The first name used for hello request tests
	 */
	private static final String TEST_HELLO_FIRSTNAME = "Mario";



	/**
	 * The last name used for hello request tests
	 */
	private static final String TEST_HELLO_LASTNAME = "Rossi";



	/**
	 * Before all tests, start the gRCP server
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@BeforeAll
	public static void startServer() throws IOException, InterruptedException {
		// Start the gRPC server, without blocking its termination after the startup
		GrpcServer.start(false);
	}



	/**
	 * Tests the hello gRPC service
	 */
	@DisplayName("gRPC HelloService test")
	@Test
	public void testHello() {
		// Get a new hello client
		GrpcClient client = new GrpcClient();
		// Get the hello response querying the hello gRPC service
		HelloResponse response = client.getHello(TEST_HELLO_FIRSTNAME, TEST_HELLO_LASTNAME);
		// Assert for not null response
		Assertions.assertNotNull(response);
		// Check hello response
		String expected = "greeting: \"Hello, " + TEST_HELLO_FIRSTNAME + " " + TEST_HELLO_LASTNAME + "\"\n";
		Assertions.assertEquals(response.toString(), expected);
	}

}
