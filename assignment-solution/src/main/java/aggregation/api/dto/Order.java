package aggregation.api.dto;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class Order {

	String batchId = StringUtils.EMPTY;
	List<Record> records = null;

	/**
	 * @return the batchId
	 */
	public String getBatchId() {
		return batchId;
	}

	/**
	 * @param batchId
	 *            the batchId to set
	 */
	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	/**
	 * @return the records
	 */
	public List<Record> getRecords() {
		return records;
	}

	/**
	 * @param records
	 *            the records to set
	 */
	public void setRecords(List<Record> records) {
		this.records = records;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Order [" + (batchId != null ? "batchId=" + batchId + ", " : "")
				+ (records != null ? "records=" + records : "") + "]";
	}

}
