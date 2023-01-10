/**
 * 
 */
package co.com.claro.schema.analytics.ctrl.response;

import co.com.claro.schema.util.StatusResponse;
import lombok.Data;

/**
 * @author User
 *
 */
@Data
public class ResponseVariablePlatafor {
	private String errorMessage;
	private StatusResponse statusResponse;

	/**
	 * 
	 */
	public ResponseVariablePlatafor() {
		super();
	}
}
