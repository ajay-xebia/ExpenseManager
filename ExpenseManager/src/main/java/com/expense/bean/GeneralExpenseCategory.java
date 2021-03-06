package com.expense.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="general_expense_category")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class GeneralExpenseCategory {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="EXPENSE_CATEGORY_TYPE_ID")
	private long expenseCategoryTypeId;
	
	@Column(name="EXPENSE_CATEGORY_TYPE_NAME", unique=true)
	private String expenseCategoryTypeName;

	public GeneralExpenseCategory() {}
	
	public GeneralExpenseCategory(long expenseCategoryTypeId, String expenseCategoryTypeName) {
		this.expenseCategoryTypeId=expenseCategoryTypeId;
		this.expenseCategoryTypeName=expenseCategoryTypeName;
	}

	public long getExpenseCategoryTypeId() {
		return expenseCategoryTypeId;
	}

	public void setExpenseCategoryTypeId(long expenseCategoryTypeId) {
		this.expenseCategoryTypeId = expenseCategoryTypeId;
	}

	public String getExpenseCategoryTypeName() {
		return expenseCategoryTypeName;
	}

	public void setExpenseCategoryTypeName(String expenseCategoryTypeName) {
		this.expenseCategoryTypeName = expenseCategoryTypeName;
	}
	
	
	
}
