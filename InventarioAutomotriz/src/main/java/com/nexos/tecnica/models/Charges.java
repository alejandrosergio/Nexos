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
@Table(name = "Charges")
public class Charges implements Serializable {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false)
    private Long ID;
	
	@Column(name = "Charge", unique = true, nullable = false)
    private String charge;
    
    @Column(name = "Created_by", nullable = false)
    private String createdBy;
    
    @Column(name = "Creation_on", nullable = false)
	@Temporal(TemporalType.DATE)
    private Date creationOn;
    
    @Column(name = "Modified_by", nullable = true)
    private String modifiedBy;
    
    @Column(name = "Modified_on", nullable = true)
	@Temporal(TemporalType.DATE)
    private Date modifiedOn;
    
    
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
	
	public String getCharge() {
		return charge;
	}
	public void setCharge(String Charge) {
		this.charge = Charge;
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
		return modifiedOn;
	}
	public void setModifiedOn(Date ModifiedOn) {
		this.modifiedOn = ModifiedOn;
	}

	private static final long serialVersionUID = -549712409229904589L;
	
	
}



