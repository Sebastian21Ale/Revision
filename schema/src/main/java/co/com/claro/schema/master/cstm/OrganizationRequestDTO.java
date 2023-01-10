package co.com.claro.schema.master.cstm;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class OrganizationRequestDTO implements Serializable{

	private Long id;

	private String genesysID;

	private String genesysSecret;

	private Date expireDate;

	private String objectURI;

	private String shortName;

	private String completeName;

	private String webSiteURL;

	private String nit;

	private String email;

	private String phoneNumber;

	private String address;

	private String country;

	private String city;

	private String domain;

	private Long sectorID;

	private Integer status = -2;

	private Integer recordStatus = 1;

}
