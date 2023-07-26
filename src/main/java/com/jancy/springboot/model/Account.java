package com.jancy.springboot.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="accountdetails")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long accountId;
	
	@Column(name="customer_id")
	Long customerId;
	@Column(name="account_balance")
	Double accountBalance;
	@Column(name="created_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	Date createdDate;
	@Column(name="created_by")
	String createdBy;
	
	
	public Account() {
		
	}
	
	public Account(Long customerId, Double accountBalance, Date createdDate, String createdBy) {
		super();
		this.customerId = customerId;
		this.accountBalance = accountBalance;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
	}
	
	
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public Double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
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
		return "Customer [accountId=" + accountId + ", customerId=" + customerId + ", accountBalance=" + accountBalance
				+ ", createdDate=" + createdDate + ", createdBy=" + createdBy + "]";
	}
	
	
	

}
