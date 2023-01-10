package co.com.claro.schema.master.cstm;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class CampaingOrganizationDTO implements Serializable{

	private Long id;

	private OrganizationDTO organizationID;

	private String name;

	private Date start;

	private Date end;

	private Integer status = 1;

	private Integer recordStatus = 1;

}
