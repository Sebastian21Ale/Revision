package co.com.claro.schema.master.cstm;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import co.com.claro.schema.master.pmtr.SectorDTO;
import lombok.Data;

@Data
@JsonInclude(value =  Include.NON_NULL)
public class OrganizationDTO implements Serializable{

	private Long id;

	private String genesysID;

	private String genesysSecret;

	private Date expireDate;

	private String objectURI;

	private String shortName;

	private String completeName;

	private String webSiteURL;

	private String domain;

	private SectorDTO sector;

	private Integer status = -2;

	private Integer recordStatus = 1;
}
