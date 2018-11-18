package gov.smartagro.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "soilhealthcard")
public class Soilhealthcard  {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cardid;
	private Long cardnumber;
	private Long n;
	private Long p;
	private Long k;
	private Long zn;
	private Long mg;
	private Long fe;

	public Soilhealthcard() {
		
	}


}
