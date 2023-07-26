package com.jancy.springboot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="transactiondetails")
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long transactionId;
	
	@Column(name="account_id")
	Long accountId;
	@Column(name="transaction_type")
	String transactionType;
	@Column(name="transaction_amount")
	Double transactionAmount;
	
	public Transaction() {
		
	}
	
	
	public Transaction(Long accountId, String transactionType, Double transactionAmount) {
		super();
		this.accountId = accountId;
		this.transactionType = transactionType;
		this.transactionAmount = transactionAmount;
	}
	
	
	public Long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public Double getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(Double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	
	
	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", accountId=" + accountId + ", transactionType="
				+ transactionType + ", transactionAmount=" + transactionAmount + "]";
	}
	
	
	

}
