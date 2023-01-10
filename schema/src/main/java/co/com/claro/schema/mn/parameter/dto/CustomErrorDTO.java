package co.com.claro.schema.mn.parameter.dto;

import java.io.Serializable;
import java.util.Date;

import co.com.claro.schema.master.cstm.ServiceDTO;
import lombok.Data;

@Data
public class CustomErrorDTO implements Serializable{

	private Long id;

	private ServiceDTO serviceID;

	private Integer typeId;

	private Integer code;

	private Integer otherCode;

	private String name;

	private String message;

	private Integer status = 1;

	private Date recordInsertDate = new Date();

	private String recordInserteUser;

	private Date recordLastUpdateDate = new Date();

	private String recordLastUpdateUser;

	private Integer recordStatus = 1;

}
