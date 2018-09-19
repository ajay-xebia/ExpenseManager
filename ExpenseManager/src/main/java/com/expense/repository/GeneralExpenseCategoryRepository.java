package com.expense.repository;

import org.springframework.data.repository.CrudRepository;

import com.expense.bean.GeneralExpenseCategory;
public interface GeneralExpenseCategoryRepository extends CrudRepository<GeneralExpenseCategory, Long>{

}
