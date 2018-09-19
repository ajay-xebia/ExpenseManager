package com.expense.repository;

import org.springframework.data.repository.CrudRepository;

import com.expense.bean.Expense;
public interface ExpenseRepository extends CrudRepository<Expense, Long>{

}
