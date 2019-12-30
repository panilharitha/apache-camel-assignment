package aggregation.api.configuration;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class ApplicationRouteBuilder extends RouteBuilder {

	private static final Logger logger = LoggerFactory.getLogger(ApplicationRouteBuilder.class);

	@Override
	public void configure() throws Exception {
		restConfiguration().contextPath("") //
				.port(8080).enableCORS(true).apiContextPath("/api-doc")
				.apiProperty("api.title", "Aggrecation assignment API").apiProperty("api.version", "v1")
				.apiProperty("cors", "true") // cross-site
				.apiContextRouteId("doc-api").component("servlet").bindingMode(RestBindingMode.json)
				.dataFormatProperty("prettyPrint", "true");

	}

}
