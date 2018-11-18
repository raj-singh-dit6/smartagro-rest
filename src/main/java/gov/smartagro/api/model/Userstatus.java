package gov.smartagro.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "userstatus")
public class Userstatus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userstatusid;
	private Long userid;
	private Boolean nval;
	private Boolean pval;
	private Boolean kval;
	private Boolean sm;
	private Boolean h;
	private Boolean t;

	public Userstatus() {

	}

}
