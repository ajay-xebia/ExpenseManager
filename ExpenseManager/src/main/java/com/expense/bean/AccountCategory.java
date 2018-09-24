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
	@Column(name="ACCOUNT_CATEGORY_ID")
	private long accountCategoryId;
	
	@Column(name="ACCOUNT_CATEGORY_NAME", unique=true)
	private String accountCategoryName;

	public AccountCategory(){}
	public AccountCategory(long accountCategoryId, String accountCategoryName) {
		this.accountCategoryName=accountCategoryName;
		this.accountCategoryId=accountCategoryId;
	}

	public long getAccountId() {
		return accountCategoryId;
	}

	public void setAccountId(long accountId) {
		this.accountCategoryId = accountId;
	}

	public String getAccountCategoryName() {
		return accountCategoryName;
	}

	public void setAccountCategoryName(String accountCategoryName) {
		this.accountCategoryName = accountCategoryName;
	}

}
