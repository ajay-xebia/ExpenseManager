package com.expense.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="core_expense_category")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CoreExpenseCategory {
	@Id
	@Column(name="EXPENSE_CATEGORY_ID")
	private long expenseCategoryId;
	
	
	@Column(name="EXPENSE_CATEGORY_NAME", unique=true)
	private String categoryName;
	
	@Column(name="GENERAL_EXPENSE_CATEGORY_ID")
	private long generalExpenseCategoryId; 

	public CoreExpenseCategory(){}
	public CoreExpenseCategory(long expenseCategoryId, String categoryName, long generalExpenseCategoryId) {
		this.expenseCategoryId=expenseCategoryId;
		this.categoryName=categoryName;
		this.generalExpenseCategoryId=generalExpenseCategoryId;
	}

	public long getExpenseCategoryId() {
		return expenseCategoryId;
	}

	public void setExpenseCategoryId(long expenseCategoryId) {
		this.expenseCategoryId = expenseCategoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public long getGeneralExpenseCategoryId() {
		return generalExpenseCategoryId;
	}

	public void setGeneralExpenseCategoryId(long generalExpenseCategoryId) {
		this.generalExpenseCategoryId = generalExpenseCategoryId;
	}
}
