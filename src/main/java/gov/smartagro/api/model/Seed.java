package gov.smartagro.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "seed")
public class Seed  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seedid;
	private Long cropid;
	private String nvalueMin;
	private String pvalueMin;
	private String kvalueMin;
	private String nvalueMax;
	private String pvalueMax;
	private String kvalueMax;
	private String soilmoistureMin;
	private String tempretureMin;
	private String reletivehumidityMin;
	private String humidityMin;
	private String soilmoistureMax;
	private String tempretureMax;
	private String reletivehumidityMax;
	private String humidityMax;
	private String seedname;

	public Seed() {

	}

}
