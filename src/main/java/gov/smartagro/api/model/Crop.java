package gov.smartagro.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import gov.smartagro.api.model.audit.DateAudit;
import lombok.Data;

@Entity
@Table(name = "crop", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
            "cropname"
        })
})
@Data
public class Crop extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 200)
    private String cropname;

    @NotBlank
    @Size(max = 100)
    private String cropType;


    public Crop() {

    }


	public Crop(Long id, @NotBlank @Size(max = 200) String cropname, @NotBlank @Size(max = 100) String cropType) {
		super();
		this.id = id;
		this.cropname = cropname;
		this.cropType = cropType;
	}
    
    


}