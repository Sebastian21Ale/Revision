package co.com.claro.schema.master.pmtr;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class LicenseDTO implements Serializable {

	private Long id;

	private String name;

	private String type;

	private Integer status = 1;

	private Date recordLastUpdateDate = new Date();

	private Date recordInsertDate = new Date();

	private String recordInsertUser;

	private String recordLastUpdateUser;

	private Integer recordStatus = 1;

}
