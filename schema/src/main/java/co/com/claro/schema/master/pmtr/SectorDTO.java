package co.com.claro.schema.master.pmtr;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class SectorDTO implements Serializable{

	private Long id;

	private String name;

	private Integer status = 1;

	private Date recordInsertDate = new Date();

	private String recordInsertUser;

	private Date recordLastUpdateDate = new Date();

	private String recordLastUpdateUser;

	private Integer recordStatus = 1;
}
