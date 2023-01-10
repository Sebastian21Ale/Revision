package co.com.claro.schema.mn.parameter.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class ErrorDTO implements Serializable {

	private Long id;

	private Integer typeId;

	private Integer code;

	private Integer otherCode;

	private String name;

	private String message;

	private Integer status = 1;

	private String recordInserteUser;

	private Date recordLastUpdateDate = new Date();

	private Date recordInsertDate = new Date();

	private String recordLastUpdateUser;

	private Integer recordStatus = 1;

}
