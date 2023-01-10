package co.com.claro.schema.master.cstm;

import java.io.Serializable;

import lombok.Data;

@Data
public class ProcessOrganizationDTO implements Serializable{

	private Long processID;

	private OrganizationDTO organizationID;

	private Long secuence;

	private String name;

	private Integer status = 1;

	private Integer nofExecutions = -2;

	private Integer recordStatus = 1;

}
