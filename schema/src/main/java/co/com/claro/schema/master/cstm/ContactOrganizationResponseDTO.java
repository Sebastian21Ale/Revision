package co.com.claro.schema.master.cstm;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(value =  Include.NON_NULL)
public class ContactOrganizationResponseDTO implements Serializable {

	private Long id;

	private OrganizationDTO organization;

	private String name;

	private String phoneNumber;

	private String email;

	private String address;

	private String nit;

	private String country;

	private String city;

	private Integer notificationFlag;

	private Integer recordStatus = 1;

}
