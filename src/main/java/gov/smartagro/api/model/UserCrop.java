package gov.smartagro.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "usercrop")
public class UserCrop extends BaseDomain {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long usercropid;

	private Long cropid;

	private Long seedid;

	private Long userid;
	
	

}
