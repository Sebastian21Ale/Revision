/**
 * 
 */
package com.analytics.co.model.response;

import co.com.claro.schema.util.StatusResponse;

/**
 * 
 * Data Transfer Object Response Api
 * 
 * @author Andres Capera
 * @version 0.1
 *
 */
public class ResponseConversation {
	private String errorMessage;
	private StatusResponse statusResponse;
	
    public ResponseConversation() {
        super();
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
