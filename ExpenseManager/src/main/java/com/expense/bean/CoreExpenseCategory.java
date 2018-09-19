package com.expense.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="core_expense_category")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CoreExpenseCategory {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="EXPENSE_CATEGORY_ID")
	private long expenseCategoryId;
	
	@Column(name="EXPENSE_CATEGORY_NAME")
	private String categoryName;
	
	@Column(name="EXPENSE_CATEGORY_TYPE")
	private String categoryType;

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

	public String getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}
	
}
