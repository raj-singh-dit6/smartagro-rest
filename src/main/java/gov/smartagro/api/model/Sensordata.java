package gov.smartagro.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "sensordata")
public class Sensordata extends BaseDomain {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sensordataid;
	private String tempreture;
	private String humidity;
	private String relativehumidity;
	private String soilmoisture;
	private String nvalue;
	private String pvalue;
	private String kvalue;
	private String sensorid;

	public Sensordata() {
		
	}


}
