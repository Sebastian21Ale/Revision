package co.com.claro.schema.master.cstm;

import java.io.Serializable;

import lombok.Data;

@Data
public class ContactOrganizationRequestDTO implements Serializable {

	private Long id;

	private OrganizationDTO organization;

	private String address;

	private String phoneNumber;

	private String name;

	private String email;

	private String nit;

	private String phone;

	private String country;

	private String city;

	private Long typeLicense;

	private Integer nofLicenses;

	private Integer notificationFlag;

}
