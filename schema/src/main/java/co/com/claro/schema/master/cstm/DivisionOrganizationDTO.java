package co.com.claro.schema.master.cstm;

import java.io.Serializable;

import lombok.Data;

@Data
public class DivisionOrganizationDTO implements Serializable {

	private Long id;

	private OrganizationDTO organizationID;

	private String divisionID;

	private String name;

	private Integer status = 1;

	private Integer recordStatus = 1;

}
