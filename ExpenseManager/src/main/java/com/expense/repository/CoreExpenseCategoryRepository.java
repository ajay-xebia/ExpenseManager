package com.expense.repository;

import org.springframework.data.repository.CrudRepository;

import com.expense.bean.CoreExpenseCategory;
import com.expense.bean.Expense;
public interface CoreExpenseCategoryRepository extends CrudRepository<CoreExpenseCategory, Long>{

}
