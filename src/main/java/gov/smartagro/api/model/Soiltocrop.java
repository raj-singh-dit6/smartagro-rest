package gov.smartagro.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "soiltocrop")
public class Soiltocrop  {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer soiltocropid;
	private Integer	 nvalue;
	private Integer	 pvlaue;
	private Integer	 kvalue;
	private String  bc;
	private String  ac;
	private String  wc;

	public Soiltocrop() {
		
	}


}
