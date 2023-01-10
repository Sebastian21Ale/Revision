package co.com.claro.schema.mn.parameter.dto;

import java.io.Serializable;

import co.com.claro.schema.master.cstm.ServiceDTO;
import lombok.Data;

@Data
public class ErrorResponseDTO implements Serializable{

	private Long id;

	private ServiceDTO serviceID;

	private Integer typeId;

	private Integer code;

	private Integer otherCode;

	private String name;

	private String message;

	private Integer recordStatus = 1;

}
