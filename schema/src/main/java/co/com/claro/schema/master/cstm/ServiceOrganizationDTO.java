package co.com.claro.schema.master.cstm;

import java.io.Serializable;

import lombok.Data;

@Data
public class ServiceOrganizationDTO implements Serializable{

	private Long id;

	private ServiceDTO serviceTypeID;

	private OrganizationDTO organizationID;

	private String name;

	private String endPoint;

	private Integer priority;

	private Integer recordStatus = 1;

	private Integer status = 1;

}
