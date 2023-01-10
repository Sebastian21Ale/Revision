package co.com.claro.schema.mn.parameter.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class ActionErrorDTO implements Serializable{

	private ErrorDTO errorID;

	private ActionErrorIDDTO id;

	private Long nofRetries;

	private Long interval = 1L;

}
