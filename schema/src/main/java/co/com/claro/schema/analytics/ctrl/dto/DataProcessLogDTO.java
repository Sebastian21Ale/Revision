/**
 * 
 */
package co.com.claro.schema.analytics.ctrl.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.Data;

/**
 * 
 * Data Transfer Object DataProcessLogDTO
 * 
 * @author Andres Capera
 * @version 0.1
 *
 */

@Data
public class DataProcessLogDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private Integer processId;

	private Integer step;

	private Timestamp start;

	private Timestamp end;

	private Integer executionUserId;

	private Integer executionStatus;

	private Integer errorFlag;

	private String comment;

	private Integer executionTime;

	private Integer nofReads;

	private Integer nofInserts;

	private Integer nofUpdates;

	private Integer nofDeletes;

	private Integer recordStatus;

}
