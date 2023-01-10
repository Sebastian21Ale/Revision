package co.com.claro.schema.master.cstm;

import java.io.Serializable;

import lombok.Data;

@Data
public class OrganizationResponseDTO implements Serializable{

	private OrganizationDTO organization;

	private ContactOrganizationDTO contactOrganization;

}
