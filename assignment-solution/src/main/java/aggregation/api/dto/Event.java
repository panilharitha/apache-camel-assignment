package aggregation.api.dto;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;
import org.apache.commons.lang3.StringUtils;

@CsvRecord(separator = ",")
public class Event {

	@DataField(pos = 1)
	long eventCnt;
	@DataField(pos = 2)
	String locationCd = StringUtils.EMPTY;
	@DataField(pos = 3)
	String locationId1 = StringUtils.EMPTY;
	@DataField(pos = 4)
	String locationId2 = StringUtils.EMPTY;
	@DataField(pos = 5)
	String addrNbr = StringUtils.EMPTY;

	/**
	 * @return the eventCnt
	 */
	public long getEventCnt() {
		return eventCnt;
	}

	/**
	 * @param eventCnt
	 *            the eventCnt to set
	 */
	public void setEventCnt(long eventCnt) {
		this.eventCnt = eventCnt;
	}

	/**
	 * @return the locationCd
	 */
	public String getLocationCd() {
		return locationCd;
	}

	/**
	 * @param locationCd
	 *            the locationCd to set
	 */
	public void setLocationCd(String locationCd) {
		this.locationCd = locationCd;
	}

	/**
	 * @return the locationId1
	 */
	public String getLocationId1() {
		return locationId1;
	}

	/**
	 * @param locationId1
	 *            the locationId1 to set
	 */
	public void setLocationId1(String locationId1) {
		this.locationId1 = locationId1;
	}

	/**
	 * @return the locationId2
	 */
	public String getLocationId2() {
		return locationId2;
	}

	/**
	 * @param locationId2
	 *            the locationId2 to set
	 */
	public void setLocationId2(String locationId2) {
		this.locationId2 = locationId2;
	}

	/**
	 * @return the addrNbr
	 */
	public String getAddrNbr() {
		return addrNbr;
	}

	/**
	 * @param addrNbr
	 *            the addrNbr to set
	 */
	public void setAddrNbr(String addrNbr) {
		this.addrNbr = addrNbr;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Event [eventCnt=" + eventCnt + ", " + (locationCd != null ? "locationCd=" + locationCd + ", " : "")
				+ (locationId1 != null ? "locationId1=" + locationId1 + ", " : "")
				+ (locationId2 != null ? "locationId2=" + locationId2 + ", " : "")
				+ (addrNbr != null ? "addrNbr=" + addrNbr : "") + "]";
	}

}
