/**
 * 
 */
package com.analytics.co.model.resquest;

/**
 * @author User
 *
 */
public class RequesMetric {

	/** Details jobs max concurrent access values */
	private Integer nofAnCnvrDetJobsId;

	/** Maximum operations per second for details jobs */
	private Integer nofAnCnvrDetJobsRateId;

	/** The absolute maximum content length of a request payload */
	private Integer nofAnCnvrAbsoReqBytes;
	private Integer nofAnCnvrAbsoReqBytesId;

	/**
	 * The maximum number of requests per client credentials grant token per minute
	 */
	private Integer nofAnCnvrCliCredTokenId;

	/**
	 * The maximum number of requests per organization per OAuth client per user per
	 * minute
	 */
	private Integer nofAnCnvrUserRateMinute;
	private Integer nofAnCnvrUserRateMinuteId;

	/** The maximum content length of a request payload */
	private Integer nofAnCnvrReqBytes;
	private Integer nofAnCnvrReqBytesId;

	/** The maximum number of requests per token per minute */
	private Integer nofAnCnvrTokenMinute;
	private Integer nofAnCnvrTokenMinuteId;
	
	
	public RequesMetric() {
		super();
	}

	/**
	 * @return the nofAnCnvrDetJobsId
	 */
	public Integer getNofAnCnvrDetJobsId() {
		return nofAnCnvrDetJobsId;
	}

	/**
	 * @param nofAnCnvrDetJobsId the nofAnCnvrDetJobsId to set
	 */
	public void setNofAnCnvrDetJobsId(Integer nofAnCnvrDetJobsId) {
		this.nofAnCnvrDetJobsId = nofAnCnvrDetJobsId;
	}

	/**
	 * @return the nofAnCnvrDetJobsRateId
	 */
	public Integer getNofAnCnvrDetJobsRateId() {
		return nofAnCnvrDetJobsRateId;
	}

	/**
	 * @param nofAnCnvrDetJobsRateId the nofAnCnvrDetJobsRateId to set
	 */
	public void setNofAnCnvrDetJobsRateId(Integer nofAnCnvrDetJobsRateId) {
		this.nofAnCnvrDetJobsRateId = nofAnCnvrDetJobsRateId;
	}

	/**
	 * @return the nofAnCnvrAbsoReqBytes
	 */
	public Integer getNofAnCnvrAbsoReqBytes() {
		return nofAnCnvrAbsoReqBytes;
	}

	/**
	 * @param nofAnCnvrAbsoReqBytes the nofAnCnvrAbsoReqBytes to set
	 */
	public void setNofAnCnvrAbsoReqBytes(Integer nofAnCnvrAbsoReqBytes) {
		this.nofAnCnvrAbsoReqBytes = nofAnCnvrAbsoReqBytes;
	}

	/**
	 * @return the nofAnCnvrAbsoReqBytesId
	 */
	public Integer getNofAnCnvrAbsoReqBytesId() {
		return nofAnCnvrAbsoReqBytesId;
	}

	/**
	 * @param nofAnCnvrAbsoReqBytesId the nofAnCnvrAbsoReqBytesId to set
	 */
	public void setNofAnCnvrAbsoReqBytesId(Integer nofAnCnvrAbsoReqBytesId) {
		this.nofAnCnvrAbsoReqBytesId = nofAnCnvrAbsoReqBytesId;
	}

	/**
	 * @return the nofAnCnvrCliCredTokenId
	 */
	public Integer getNofAnCnvrCliCredTokenId() {
		return nofAnCnvrCliCredTokenId;
	}

	/**
	 * @param nofAnCnvrCliCredTokenId the nofAnCnvrCliCredTokenId to set
	 */
	public void setNofAnCnvrCliCredTokenId(Integer nofAnCnvrCliCredTokenId) {
		this.nofAnCnvrCliCredTokenId = nofAnCnvrCliCredTokenId;
	}

	/**
	 * @return the nofAnCnvrUserRateMinute
	 */
	public Integer getNofAnCnvrUserRateMinute() {
		return nofAnCnvrUserRateMinute;
	}

	/**
	 * @param nofAnCnvrUserRateMinute the nofAnCnvrUserRateMinute to set
	 */
	public void setNofAnCnvrUserRateMinute(Integer nofAnCnvrUserRateMinute) {
		this.nofAnCnvrUserRateMinute = nofAnCnvrUserRateMinute;
	}

	/**
	 * @return the nofAnCnvrUserRateMinuteId
	 */
	public Integer getNofAnCnvrUserRateMinuteId() {
		return nofAnCnvrUserRateMinuteId;
	}

	/**
	 * @param nofAnCnvrUserRateMinuteId the nofAnCnvrUserRateMinuteId to set
	 */
	public void setNofAnCnvrUserRateMinuteId(Integer nofAnCnvrUserRateMinuteId) {
		this.nofAnCnvrUserRateMinuteId = nofAnCnvrUserRateMinuteId;
	}

	/**
	 * @return the nofAnCnvrReqBytes
	 */
	public Integer getNofAnCnvrReqBytes() {
		return nofAnCnvrReqBytes;
	}

	/**
	 * @param nofAnCnvrReqBytes the nofAnCnvrReqBytes to set
	 */
	public void setNofAnCnvrReqBytes(Integer nofAnCnvrReqBytes) {
		this.nofAnCnvrReqBytes = nofAnCnvrReqBytes;
	}

	/**
	 * @return the nofAnCnvrReqBytesId
	 */
	public Integer getNofAnCnvrReqBytesId() {
		return nofAnCnvrReqBytesId;
	}

	/**
	 * @param nofAnCnvrReqBytesId the nofAnCnvrReqBytesId to set
	 */
	public void setNofAnCnvrReqBytesId(Integer nofAnCnvrReqBytesId) {
		this.nofAnCnvrReqBytesId = nofAnCnvrReqBytesId;
	}

	/**
	 * @return the nofAnCnvrTokenMinute
	 */
	public Integer getNofAnCnvrTokenMinute() {
		return nofAnCnvrTokenMinute;
	}

	/**
	 * @param nofAnCnvrTokenMinute the nofAnCnvrTokenMinute to set
	 */
	public void setNofAnCnvrTokenMinute(Integer nofAnCnvrTokenMinute) {
		this.nofAnCnvrTokenMinute = nofAnCnvrTokenMinute;
	}

	/**
	 * @return the nofAnCnvrTokenMinuteId
	 */
	public Integer getNofAnCnvrTokenMinuteId() {
		return nofAnCnvrTokenMinuteId;
	}

	/**
	 * @param nofAnCnvrTokenMinuteId the nofAnCnvrTokenMinuteId to set
	 */
	public void setNofAnCnvrTokenMinuteId(Integer nofAnCnvrTokenMinuteId) {
		this.nofAnCnvrTokenMinuteId = nofAnCnvrTokenMinuteId;
	}

}
