/**
 * 
 */
package co.com.claro.schema.util;

/**
 * 
 * Data Transfer Object Error Codes
 * 
 * @author Andres Capera
 * @version 0.1
 *
 */
public class StatusResponse {
	private String status;
	private String description;

	
	/**
	 * 
	 */
	public StatusResponse() {
		super();
	}

	public StatusResponse(String status, String description) {
		this.status = status;
		this.description = description;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}
