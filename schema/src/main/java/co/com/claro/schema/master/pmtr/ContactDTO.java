package co.com.claro.schema.master.pmtr;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class ContactDTO implements Serializable {

	private Long id;

	private String name;

	private Integer status = 1;

	private String recordInsertUser;

	private String recordLastUpdateUser;

	private Integer recordStatus = 1;

	private Date recordLastUpdateDate = new Date();

	private Date recordInsertDate = new Date();

}
