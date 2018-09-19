package com.expense.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="account_category")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AccountCategory {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ACCOUNT_CATEGORY_ID")
	private long accountId;
	
	@Column(name="ACCOUNT_CATEGORY_NAME")
	private String accountCategoryName;

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public String getAccountCategoryName() {
		return accountCategoryName;
	}

	public void setAccountCategoryName(String accountCategoryName) {
		this.accountCategoryName = accountCategoryName;
	}

}
