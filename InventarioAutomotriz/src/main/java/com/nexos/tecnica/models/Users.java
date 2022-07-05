package com.nexos.tecnica.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

/**
 * @author SergioHernandez
 *
 */
@Data
@Entity
@Table(name = "Users")
public class Users implements Serializable {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false)
    private Long ID;
	
	@Column(name = "Name", unique = true, nullable = false)
    private String name;
	
	@Column(name = "Age", unique = false, nullable = false)
    private Integer age;
	
	@Column(name = "Charge", unique = false, nullable = false)
    private String charge;
	
    @Column(name = "Admission_date", nullable = false)
	@Temporal(TemporalType.DATE)
    private Date admissionDate;
    
    @Column(name = "Created_by", nullable = false)
    private String createdBy;
    
    @Column(name = "Creation_on", nullable = false)
	@Temporal(TemporalType.DATE)
    private Date creationOn;
    
    @Column(name = "Modified_by", nullable = true)
    private String modifiedBy;
    
    @Column(name = "Modified_on", nullable = true)
	@Temporal(TemporalType.DATE)
    private Date ModifiedOn;
    

	@PrePersist
	public void prePersist() {
		this.creationOn = new Date();
	}
	
    
	public Long getID() {
		return ID;
	}
	public void setID(Long ID) {
		this.ID = ID;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String Name) {
		this.name = Name;
	}
	
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer Age) {
		this.age = Age;
	}


	public String getCharge() {
		return charge;
	}
	public void setCharge(String Charge) {
		this.charge = Charge;
	}


	public Date getAdmissionDate() {
		return admissionDate;
	}
	public void setAdmissionDate(Date AdmissionDate) {
		this.admissionDate = AdmissionDate;
	}


	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String CreatedBy) {
		this.createdBy = CreatedBy;
	}
	
	public Date getCreationOn() {
		return creationOn;
	}
	public void setCreationOn(Date CreationOn) {
		this.creationOn = CreationOn;
	}
	
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String ModifiedBy) {
		this.modifiedBy = ModifiedBy;
	}
	
	public Date getModifiedOn() {
		return ModifiedOn;
	}
	public void setModifiedOn(Date ModifiedOn) {
		this.ModifiedOn = ModifiedOn;
	}
	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	private static final long serialVersionUID = 6775287975757635376L;
	
	
}



