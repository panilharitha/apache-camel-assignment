package aggregation.api.test;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

import aggregation.api.dto.Order;

import aggregation.api.rest.impl.AggregationSampleServiceImpl;

public class TestCase extends CamelTestSupport {
	
	private static final Logger logger = LoggerFactory.getLogger(TestCase.class);

	@Override
	protected RoutesBuilder createRouteBuilder() throws Exception {
		// Get Route builder from AggregationSampleServiceImpl
		return new AggregationSampleServiceImpl();
	}

	@Test
	public void testSendMatchingMessage() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		Order order = objectMapper.readValue(new File("src/data/in/sample-payload.json"), Order.class);

		MockEndpoint endpoint = getMockEndpoint("mock:mockEndPoint");

		// Call Service
		template.sendBody("direct:aggregationSampleservice", order);

		endpoint.reset();

		// Check file was generated
		endpoint.expectedBodiesReceived("Done");

		// Should complete before timeout
		endpoint.await(62, TimeUnit.SECONDS);

		// Check mock end point condition/s satisfied
		endpoint.assertIsSatisfied();
	}
}
