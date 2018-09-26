package com.expense.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.expense.bean.Expense;
import com.expense.repository.ExpenseRepository;

@Controller
@RequestMapping("/expense")
public class ExpenseEntryController {
	
	private final ExpenseRepository expenseRepository;
	
	public ExpenseEntryController(ExpenseRepository expenseRepository){
		this.expenseRepository=expenseRepository;
	}
	
	@PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String showLoginPage(/*@RequestParam("expenseDate") Date expenseDate,
    		@RequestParam("amount") double amount,
    		@RequestParam("accountName") String accountName,
    		@RequestParam("accountCategory") String accountCategory,
    		@RequestParam("coreExpenseCategory") String coreExpenseCategory,
    		@RequestParam("generalExpenseCategory") String generalExpenseCategory,
    		@RequestParam("walletRefilled") boolean walletRefilled,
    		@RequestParam("description") String description*/
    		@RequestBody Expense expense){
		/*Expense expense=new Expense();
		expense.setExpenseDate(expenseDate);
		expense.setAmount(amount);
		expense.setAccountName(accountName);
		expense.setAccountCategory(accountCategory);
		expense.setCoreExpenseCategory(coreExpenseCategory);
		expense.setGeneralExpenseCategory(generalExpenseCategory);
		expense.setWalletRefillFlag(walletRefilled);
		expense.setDescription(description);*/
		System.out.println("expense==============================>"+expense);
		//expenseRepository.save(expense);
		
        return "expense";
    }

}