package com.jancy.springboot.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="bankdetails")
public class Bank {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@Column(name="customer_name")
	String customerName;
	@Column(name="customer_address")
	String customerAddress;
	@Column(name="customer_city")
	String customerCity;
	@Column(name="phone_no")
	Integer phoneno;
	@Column(name="created_date")
	Date createdDate;
	@Column(name="created_by")
	String createdBy;
	
	
	public Bank() {
		
	}
	
	public Bank(String customerName, String customerAddress, String customerCity, Integer phoneno, Date createdDate,
			String createdBy) {
		super();
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.customerCity = customerCity;
		this.phoneno = phoneno;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
	}
	
	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public String getCustomerCity() {
		return customerCity;
	}
	public void setCustomerCity(String customerCity) {
		this.customerCity = customerCity;
	}
	public Integer getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(Integer phoneno) {
		this.phoneno = phoneno;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	
	
	
	@Override
	public String toString() {
		return "Bank [id=" + id + ", customerName=" + customerName + ", customerAddress=" + customerAddress
				+ ", customerCity=" + customerCity + ", phoneno=" + phoneno + ", createdDate=" + createdDate
				+ ", createdBy=" + createdBy + "]";
	}
	

}
