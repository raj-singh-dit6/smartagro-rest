package gov.smartagro.api.model;

import java.util.Date;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;

@MappedSuperclass
public abstract class BaseDomain 
{

	@JsonIgnore private Date modifieddate;
	@JsonIgnore private Date createddate;
	@JsonIgnore private String modifiedby;
	@JsonIgnore private String createdby;
	@JsonIgnore private Boolean retired;


	@PrePersist
	protected void onCreate()
	{
		createddate = new Date(new Date().getTime());
		modifieddate = new Date(new Date().getTime());
		retired=false;
		
	}
	
	@PreUpdate
	protected void onUpdate()
	{
		modifieddate = new Date(new Date().getTime());
		
	}

	/**
	 * @return the modifieddate
	 */
	public Date getModifieddate() {
		return modifieddate;
	}

	/**
	 * @param modifieddate the modifieddate to set
	 */
	public void setModifieddate(Date modifieddate) {
		this.modifieddate = modifieddate;
	}

	/**
	 * @return the createddate
	 */
	public Date getCreateddate() {
		return createddate;
	}

	/**
	 * @param createddate the createddate to set
	 */
	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	/**
	 * @return the modifiedby
	 */
	public String getModifiedby() {
		return modifiedby;
	}

	/**
	 * @param modifiedby the modifiedby to set
	 */
	public void setModifiedby(String modifiedby) {
		this.modifiedby = modifiedby;
	}

	/**
	 * @return the createdby
	 */
	public String getCreatedby() {
		return createdby;
	}

	/**
	 * @param createdby the createdby to set
	 */
	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	/**
	 * @return the retired
	 */
	public Boolean getRetired() {
		return retired;
	}

	/**
	 * @param retired the retired to set
	 */
	public void setRetired(Boolean retired) {
		this.retired = retired;
	}
	
	
	

}
