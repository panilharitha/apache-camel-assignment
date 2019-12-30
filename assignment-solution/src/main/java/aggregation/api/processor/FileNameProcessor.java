package aggregation.api.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class FileNameProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		exchange.getIn().setHeader(Exchange.FILE_NAME,
				exchange.getIn().getHeader("batchId") + "-" + System.currentTimeMillis() + ".csv");
	}

}
