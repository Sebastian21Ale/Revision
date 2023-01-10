/**
 * 
 */
package co.com.claro.schema.analytics.cnvr.response;

import co.com.claro.schema.util.StatusResponse;
import lombok.Data;

/**
 * 
 * Response data transfer object save method conversations
 * 
 * @author Andres Capera
 * @version 0.1
 *
 */
@Data
public class ResponseConversation {

	private String errorMessage;
	private StatusResponse statusResponse;

}
