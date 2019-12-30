package aggregation.api.dto;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;

public class Record {

	String transId = StringUtils.EMPTY;
	String transTms = null;
	int rcNum = 0;
	String clientId = StringUtils.EMPTY;
	List<Event> event = null;
	/**
	 * @return the transId
	 */
	public String getTransId() {
		return transId;
	}
	/**
	 * @param transId the transId to set
	 */
	public void setTransId(String transId) {
		this.transId = transId;
	}
	/**
	 * @return the transTms
	 */
	public String getTransTms() {
		return transTms;
	}
	/**
	 * @param transTms the transTms to set
	 */
	public void setTransTms(String transTms) {
		this.transTms = transTms;
	}
	/**
	 * @return the rcNum
	 */
	public int getRcNum() {
		return rcNum;
	}
	/**
	 * @param rcNum the rcNum to set
	 */
	public void setRcNum(int rcNum) {
		this.rcNum = rcNum;
	}
	/**
	 * @return the clientId
	 */
	public String getClientId() {
		return clientId;
	}
	/**
	 * @param clientId the clientId to set
	 */
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	/**
	 * @return the events
	 */
	public List<Event> getEvent() {
		return event;
	}
	/**
	 * @param events the events to set
	 */
	public void setEvent(List<Event> event) {
		this.event = event;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Record [" + (transId != null ? "transId=" + transId + ", " : "")
				+ (transTms != null ? "transTms=" + transTms + ", " : "") + "rcNum=" + rcNum + ", "
				+ (clientId != null ? "clientId=" + clientId + ", " : "") + (event != null ? "events=" + event : "")
				+ "]";
	}
}
