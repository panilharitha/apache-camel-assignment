package aggregation.api.rest.impl;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.spi.DataFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import aggregation.api.aggregation.RecordAggregationStrategy;
import aggregation.api.dto.Event;
import aggregation.api.processor.FileNameProcessor;
import aggregation.api.processor.SplitterProcessor;

@Component
public class AggregationSampleServiceImpl extends RouteBuilder {

	private static final Logger logger = LoggerFactory.getLogger(AggregationSampleServiceImpl.class);
	
	@Override
	public void configure() throws Exception {
		// Use for bind Event class object to csv
		DataFormat bindy = new BindyCsvDataFormat(Event.class);

		from("direct:aggregationSampleservice").routeId("aggregation-samples").tracing().log("batchId-${body}")
				.setHeader("batchId", simple("${body.batchId}")).split(body())
				/*
				 * Splitter - Remove events and collect all event into single list from all
				 * records.
				 */
				.process(new SplitterProcessor()).split(body())
				/* Aggregate records for every 10 records or 1 minute */
				.aggregate(constant(true), new RecordAggregationStrategy()).completionSize(10).completionTimeout(60000)
				/* Transform each record into CSV format */
				.marshal(bindy).process(new FileNameProcessor())
				.to("file:src/data/out?fileName=${header.CamelFileName}").log("${header.batchId} - File name : ${body}")
				//Change body to "Done" and send to mock endpoint
				.process(new Processor() {					
					@Override
					public void process(Exchange exchange) throws Exception {
						exchange.getIn().setBody("Done");
					}
				}).to("mock:mockEndPoint");
	}
}