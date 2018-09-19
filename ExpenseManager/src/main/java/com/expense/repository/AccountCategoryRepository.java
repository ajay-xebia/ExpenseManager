package com.expense.repository;

import org.springframework.data.repository.CrudRepository;

import com.expense.bean.Account;
import com.expense.bean.AccountCategory;
public interface AccountCategoryRepository extends CrudRepository<AccountCategory, Long>{

}
