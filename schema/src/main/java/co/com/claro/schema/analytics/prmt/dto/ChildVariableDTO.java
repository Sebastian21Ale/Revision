/**
 * 
 */
package co.com.claro.schema.analytics.prmt.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.Data;

/**
 * 
 * Data Transfer Object ChildVariableDTO
 * 
 * @author Andres Capera
 * @version 0.1
 *
 */
@Data
public class ChildVariableDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private String name;

	private String value;

	private Integer status;

	private Timestamp recordInsertDate;

	private String recordInsertUser;

	private Timestamp recordLastUpdateDate;

	private String recordLastUpdateUser;

	private Integer recordStatus;

}
