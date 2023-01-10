package co.com.claro.schema.master.cstm;

import java.io.Serializable;

import lombok.Data;

@Data
public class ContactOrganizationDTO implements Serializable {

	private Long id;

	private OrganizationDTO organization;

	private String name;

	private String phoneNumber;

	private String email;

	private String address;

	private String nit;

	private String country;

	private String city;

	private Integer notificationFlag = 0;

	private Integer recordStatus = 1;

}
