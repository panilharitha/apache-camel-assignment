package aggregation.api.rest;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import aggregation.api.dto.Order;

@Component
public class AggregationSampleService extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		// Sample test URL
		rest().get("/hello-world").produces(MediaType.APPLICATION_JSON_VALUE).route()
				.setBody(constant("Welcome to Spring Boot + Apache Camel")).endRest();

		//Rest json service 
		rest().post("/process").consumes(MediaType.APPLICATION_JSON_VALUE).bindingMode(RestBindingMode.auto)
				.type(Order.class).enableCORS(true).to("direct:aggregationSampleservice");
	}

}
