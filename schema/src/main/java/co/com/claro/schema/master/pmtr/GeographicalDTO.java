package co.com.claro.schema.master.pmtr;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class GeographicalDTO implements Serializable {

	private Long id;

	private String name;

	private String region;

	private String countryCode;

	private String country;

	private String department;

	private String zone;

	private String city;

	private String postalCode;

	private String recordInsertUser;

	private String recordLastUpdateUser;

	private Integer recordStatus = 1;

	private Date recordLastUpdateDate = new Date();

	private Date recordInsertDate = new Date();

}
