package aggregation.api.processor;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import aggregation.api.dto.Event;
import aggregation.api.dto.Order;
import aggregation.api.dto.Record;

public class SplitterProcessor implements Processor {

	private static final Logger logger = LoggerFactory.getLogger(SplitterProcessor.class);
	@Override
	public void process(Exchange exchange) throws Exception {
		logger.info(exchange.getIn().getHeader("batchId") +  " - Start split process");
		Order order = exchange.getIn().getBody(Order.class);
		// Extract all records and collect events
		List<Event> eventList = new ArrayList<Event>();
		for (Record record : order.getRecords()) {
			for (Event event : record.getEvent()) {
				eventList.add(event);
			}
		}
		exchange.getIn().setBody(eventList);
		logger.info(exchange.getIn().getHeader("batchId") +  " - End split process");
	}
}
