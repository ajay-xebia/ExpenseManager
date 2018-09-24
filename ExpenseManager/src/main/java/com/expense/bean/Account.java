package com.expense.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="account")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Account {
	
	@Id
	@Column(name="ACCOUNT_ID")
	private long accountId;
	
	@Column(name="ACCOUNT_NAME")
	private String accountName;
	
	@Column(name="ACCOUNT_CATEGORY")
	private String accountCategory;
	
	@Column(name="BALANCE")
	private double balance;
	
	public Account(){}
	
	public Account(long accountId, String accountName, String accountCategory, double balance) {
		this.accountId=accountId;
		this.accountName=accountName;
		this.accountCategory=accountCategory;
		this.balance=balance;
	}

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountCategory() {
		return accountCategory;
	}

	public void setAccountCategory(String accountCategory) {
		this.accountCategory = accountCategory;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
}
