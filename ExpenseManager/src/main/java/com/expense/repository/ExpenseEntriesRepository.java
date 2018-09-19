package com.expense.repository;

import org.springframework.data.repository.CrudRepository;

import com.expense.bean.ExpenseEntry;
public interface ExpenseEntriesRepository extends CrudRepository<ExpenseEntry, Long>{

}
