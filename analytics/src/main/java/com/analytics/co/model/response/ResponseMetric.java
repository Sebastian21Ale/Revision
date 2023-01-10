/**
 * 
 */
package com.analytics.co.model.response;

import co.com.claro.schema.util.StatusResponse;

/**
 * @author User
 *
 */
public class ResponseMetric {
	private String errorMessage;
	private StatusResponse statusResponse;

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
