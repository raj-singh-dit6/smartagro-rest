package gov.smartagro.api.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NaturalId;

import gov.smartagro.api.model.audit.DateAudit;
import gov.smartagro.api.payload.SignUpRequest;
import lombok.Data;

@Data
@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
            "username"
        }),
        @UniqueConstraint(columnNames = {
            "email"
        })
})
public class User extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 40)
    private String name;

    @NotBlank
    @Size(max = 15)
    private String username;

    @NaturalId
    @NotBlank
    @Size(max = 40)
    @Email
    private String email;

    @NotBlank
    @Size(max = 100)
    private String password;
    
    @Size(max = 100)
    private String mobileNumber;
    
    @Size(max = 100)
    private String soilHealthCardId;
    
    @Size(max = 100)
    @NotBlank
    private String adharCardNo;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();
    
    
    public User() {

    }

    public User(SignUpRequest signUpRequest) {
        this.name = signUpRequest.getName();
        this.username = signUpRequest.getUsername();
        this.email = signUpRequest.getEmail();
        this.password = signUpRequest.getPassword();
        this.mobileNumber=signUpRequest.getMobileNumber();
        this.adharCardNo=signUpRequest.getAdharCardNo();
        this.soilHealthCardId=signUpRequest.getSoilHealthCardId();
    }

}