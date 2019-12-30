package aggregation.api.aggregation;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import aggregation.api.dto.Event;

public class RecordAggregationStrategy implements AggregationStrategy {

	private static final Logger logger = LoggerFactory.getLogger(RecordAggregationStrategy.class);
	
	public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
		if (oldExchange == null) {
			List<Event> oderEvent = new ArrayList<Event>();
			Event event = newExchange.getIn().getBody(Event.class);
			oderEvent.add(event);			
			newExchange.getIn().setBody(oderEvent);
			return newExchange;
		}

		List<Event> oderEvent = oldExchange.getIn().getBody(ArrayList.class);
		Event event = newExchange.getIn().getBody(Event.class);
		oderEvent.add(event);
		newExchange.getIn().setBody(oderEvent);
		return oldExchange;
	}
	
}
