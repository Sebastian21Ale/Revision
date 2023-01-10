package co.com.claro.schema.master.cstm;

import java.io.Serializable;

import co.com.claro.schema.master.pmtr.LicenseDTO;
import co.com.claro.schema.master.pmtr.PlatformDTO;
import lombok.Data;

@Data
public class PlatformOrganizationDTO implements Serializable{

	private OrganizationDTO organizationID;

	private PlatformDTO platformID;

	private LicenseDTO licenseID;

	private String version;

	private Integer noFlicenses = -1;

	private Integer recordStatus = 1;
}
