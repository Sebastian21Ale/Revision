/**
 * 
 */
package com.analytics.co.model.response;

import java.sql.Timestamp;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonInclude;

import co.com.claro.schema.util.StatusResponse;

/**
 * 
 * Data Transfer Object Response Analytics
 * 
 * @author Andres Capera
 * @version 0.1
 *
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ResponseAnalytics {

	private Long nofConversation;
	private Long nofConversationBytes;
	private Timestamp dateStart;
	private Timestamp dateEnd;
	private LocalTime timeStart;
	private LocalTime timeEnd;
	private Double timeResponse;
	private String errorMessage;
	private StatusResponse statusResponse;

	/**
	 * @return the nofConversation
	 */
	public Long getNofConversation() {
		return nofConversation;
	}

	/**
	 * @param nofConversation the nofConversation to set
	 */
	public void setNofConversation(Long nofConversation) {
		this.nofConversation = nofConversation;
	}

	/**
	 * @return the nofConversationBytes
	 */
	public Long getNofConversationBytes() {
		return nofConversationBytes;
	}

	/**
	 * @param nofConversationBytes the nofConversationBytes to set
	 */
	public void setNofConversationBytes(Long nofConversationBytes) {
		this.nofConversationBytes = nofConversationBytes;
	}

	/**
	 * @return the dateStart
	 */
	public Timestamp getDateStart() {
		return dateStart;
	}

	/**
	 * @param dateStart the dateStart to set
	 */
	public void setDateStart(Timestamp dateStart) {
		this.dateStart = dateStart;
	}

	/**
	 * @return the dateEnd
	 */
	public Timestamp getDateEnd() {
		return dateEnd;
	}

	/**
	 * @param dateEnd the dateEnd to set
	 */
	public void setDateEnd(Timestamp dateEnd) {
		this.dateEnd = dateEnd;
	}

	/**
	 * @return the timeStart
	 */
	public LocalTime getTimeStart() {
		return timeStart;
	}

	/**
	 * @param timeStart the timeStart to set
	 */
	public void setTimeStart(LocalTime timeStart) {
		this.timeStart = timeStart;
	}

	/**
	 * @return the timeEnd
	 */
	public LocalTime getTimeEnd() {
		return timeEnd;
	}

	/**
	 * @param timeEnd the timeEnd to set
	 */
	public void setTimeEnd(LocalTime timeEnd) {
		this.timeEnd = timeEnd;
	}

	/**
	 * @return the timeResponse
	 */
	public Double getTimeResponse() {
		return timeResponse;
	}

	/**
	 * @param timeResponse the timeResponse to set
	 */
	public void setTimeResponse(Double timeResponse) {
		this.timeResponse = timeResponse;
	}

	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * @return the statusResponse
	 */
	public StatusResponse getStatusResponse() {
		return statusResponse;
	}

	/**
	 * @param statusResponse the statusResponse to set
	 */
	public void setStatusResponse(StatusResponse statusResponse) {
		this.statusResponse = statusResponse;
	}

}
