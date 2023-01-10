/**
 * 
 */
package com.analytics.co.model.response;

import co.com.claro.schema.util.StatusResponse;

/**
 * 
 * Data Transfer Object Response Conversation Details
 * 
 * @author Andres Capera
 * @version 0.1
 *
 */
public class ResponseConversationDetails {
	private String data;
	private Long nofConversation;
	private Long nofConversationBytes;
	private String errorMessage;
	private StatusResponse statusResponse;

	/**
	 * @return the data
	 */
	public String getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(String data) {
		this.data = data;
	}

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
