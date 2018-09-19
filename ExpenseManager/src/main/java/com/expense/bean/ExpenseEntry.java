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
@Table(name="expense_entries")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ExpenseEntry {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
	
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
    
    @Column(name="EXPENSE_CATEGORY")
    private String expenseCategory;
    
    @Column(name="EXPENSE_SUB_CATEGORY")
    private String expenseSubCategory;
    
    @Column(name="PAYMENT_CATEGORY")
    private String paymentCategory;
    
    @Column(name="PAYMENT_SUB_CATEGORY")
    private String paymentSubCategory;
    
    @Column(name="AMOUNT")
    private double amount;
    
    @Column(name="DESCRIPTION")
    private String description;
    
    @Column(name="WALLET_REFILL")
    private boolean walletRefillFlag;
    
    @Column(name="ACCOUNT_ID")
    private long accountId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getExpenseDate() {
		return expenseDate;
	}

	public void setExpenseDate(Date expenseDate) { 
		this.expenseDate = expenseDate;
	}

	public String getExpenseCategory() {
		return expenseCategory;
	}

	public void setExpenseCategory(String expenseCategory) {
		this.expenseCategory = expenseCategory;
	}

	public String getExpenseSubCategory() {
		return expenseSubCategory;
	}

	public void setExpenseSubCategory(String expenseSubCategory) {
		this.expenseSubCategory = expenseSubCategory;
	}

	public String getPaymentCategory() {
		return paymentCategory;
	}

	public void setPaymentCategory(String paymentCategory) {
		this.paymentCategory = paymentCategory;
	}

	public String getPaymentSubCategory() {
		return paymentSubCategory;
	}

	public void setPaymentSubCategory(String paymentSubCategory) {
		this.paymentSubCategory = paymentSubCategory;
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

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}
}
