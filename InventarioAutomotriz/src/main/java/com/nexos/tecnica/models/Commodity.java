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
@Table(name = "Commodity")
public class Commodity implements Serializable {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false)
    private Long ID;
	
	@Column(name = "Product", unique = true, nullable = false)
    private String product;
	
	@Column(name = "Quantity", unique = false, nullable = false)
    private Integer quantity;
	
    @Column(name = "Admission_date", nullable = false)
	@Temporal(TemporalType.DATE)
    private Date admissionDate;
    
	@Column(name = "User_insert", unique = false, nullable = false)
    private String userInsert;
    
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
    
    
	public Commodity() {
		super();
	}

	
	public Commodity(Long iD) {
		super();
		ID = iD;
	}

	
	public Commodity(String product) {
		super();
		this.product = product;
	}
	
	


	public Commodity(Date creationOn) {
		super();
		this.creationOn = creationOn;
	}


	public Commodity(String product, Integer quantity, Date admissionDate, String userInsert, String createdBy,
			Date creationOn) {
		super();
		this.product = product;
		this.quantity = quantity;
		this.admissionDate = admissionDate;
		this.userInsert = userInsert;
		this.createdBy = createdBy;
		this.creationOn = creationOn;
	}


	public Commodity(Long ID, String product, Integer quantity, Date admissionDate, String userInsert, String modifiedBy,
			Date modifiedOn, String createdBy, Date creationOn) {
		super();
		this.ID = ID;
		this.product = product;
		this.quantity = quantity;
		this.admissionDate = admissionDate;
		this.userInsert = userInsert;
		this.createdBy = createdBy;
		this.creationOn = creationOn;
		this.modifiedBy = modifiedBy;
		this.modifiedOn = modifiedOn;
	}


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
	
	public String getProduct() {
		return product;
	}
	public void setProduct(String Product) {
		this.product = Product;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer Quantity) {
		this.quantity = Quantity;
	}


	public Date getAdmissionDate() {
		return admissionDate;
	}
	public void setAdmissionDate(Date AdmissionDate) {
		this.admissionDate = AdmissionDate;
	}


	public String getUserInsert() {
		return userInsert;
	}
	public void setUserInsert(String UserInsert) {
		this.userInsert = UserInsert;
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
	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	private static final long serialVersionUID = 2581850662893914008L;
	
}



