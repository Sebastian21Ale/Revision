/**
 * 
 */
package co.com.claro.schema.analytics.ctrl.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import co.com.claro.schema.util.StatusResponse;
import lombok.Data;

/**
 * 
 * Response data transfer object error log
 * 
 * @author Andres Capera
 * @version 0.1
 *
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Data
public class ResponseProcessLog {

	private String errorMessage;
	private StatusResponse statusResponse;

}
