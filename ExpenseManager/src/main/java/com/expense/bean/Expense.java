package com.expense.bean;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="expense")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Expense {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="EXPENSE_ID")
    private long expenseId;
	
    /*
     *  expense_id INT AUTO_INCREMENT,
		expense_date Date NOT NULL,
		expense_category TEXT NOT NULL,
		expense_sub_category TEXT NOT NULL,
		payment_category TEXT NOT NULL,
		payment_sub_category TEXT NOT NULL,
		amount INT NOT NULL,
		description TEXT,
		walletRefill BOOLEAN,
     */
    @Column(name="EXPENSE_DATE")
    private Date expenseDate;
    
    @Column(name="CORE_EXPENSE_CATEGORY")
    private String coreExpenseCategory;
    
    @Column(name="GENERAL_EXPENSE_CATEGORY")
    private String generalExpenseCategory;
    
    @Column(name="ACCOUNT_NAME")
    private String accountName;
    
    @Column(name="ACCOUNT_CATEGORY")
    private String accountCategory;
    
    @Column(name="AMOUNT")
    private double amount;
    
    @Column(name="DESCRIPTION")
    private String description;
    
    @Column(name="WALLET_REFILL")
    private boolean walletRefillFlag;

	public long getExpenseId() {
		return expenseId;
	}

	public void setExpenseId(long expenseId) {
		this.expenseId = expenseId;
	}

	public Date getExpenseDate() {
		return expenseDate;
	}

	public void setExpenseDate(Date expenseDate) {
		this.expenseDate = expenseDate;
	}

	public String getCoreExpenseCategory() {
		return coreExpenseCategory;
	}

	public void setCoreExpenseCategory(String coreExpenseCategory) {
		this.coreExpenseCategory = coreExpenseCategory;
	}

	public String getGeneralExpenseCategory() {
		return generalExpenseCategory;
	}

	public void setGeneralExpenseCategory(String generalExpenseCategory) {
		this.generalExpenseCategory = generalExpenseCategory;
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

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isWalletRefillFlag() {
		return walletRefillFlag;
	}

	public void setWalletRefillFlag(boolean walletRefillFlag) {
		this.walletRefillFlag = walletRefillFlag;
	}
}
