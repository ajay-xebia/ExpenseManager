package com.expense.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.expense.bean.Account;
import com.expense.bean.AccountCategory;
import com.expense.bean.CoreExpenseCategory;
import com.expense.bean.Expense;
import com.expense.bean.GeneralExpenseCategory;
import com.expense.repository.AccountCategoryRepository;
import com.expense.repository.AccountRepository;
import com.expense.repository.CoreExpenseCategoryRepository;
import com.expense.repository.ExpenseRepository;
import com.expense.repository.GeneralExpenseCategoryRepository;

@Controller
@RequestMapping("/data")
public class AppDataController {
	
	private final GeneralExpenseCategoryRepository generalExpenseCategoryRepository;
	private final CoreExpenseCategoryRepository coreExpenseCategoryRepository;
	private final AccountCategoryRepository accountCategoryRepository;
	private final AccountRepository accountRepository;
	private final ExpenseRepository expenseRepository;
	
	@Autowired
	public AppDataController(GeneralExpenseCategoryRepository generalExpenseCategoryRepository, 
			CoreExpenseCategoryRepository coreExpenseCategoryRepository,
			AccountCategoryRepository accountCategoryRepository,
			AccountRepository accountRepository,
			ExpenseRepository expenseRepository) {
		this.generalExpenseCategoryRepository = generalExpenseCategoryRepository;
		this.coreExpenseCategoryRepository=coreExpenseCategoryRepository;
		this.accountCategoryRepository=accountCategoryRepository;
		this.accountRepository=accountRepository;
		this.expenseRepository=expenseRepository;
	}
	
	@RequestMapping(value="", method=RequestMethod.GET)
    public String test(ModelMap model){
    	return "expense";
    }
	
	@RequestMapping(value="/general", method=RequestMethod.GET)
    public String prepareGeneral(ModelMap model){
		generalExpenseCategoryRepository.save(new GeneralExpenseCategory(1, "DAILY"));
    	generalExpenseCategoryRepository.save(new GeneralExpenseCategory(2, "MONTHLY"));
    	generalExpenseCategoryRepository.save(new GeneralExpenseCategory(3, "OPTIONAL"));
    	generalExpenseCategoryRepository.save(new GeneralExpenseCategory(4, "UNPLANNED"));
    	generalExpenseCategoryRepository.save(new GeneralExpenseCategory(5, "SAVINGS"));
    	System.out.println("================================================DB Entries: {}"+ generalExpenseCategoryRepository.count());
        
    	return "expense";
    }
	
	@RequestMapping(value="/core", method=RequestMethod.GET)
	public String prepareCore(ModelMap model){
		coreExpenseCategoryRepository.save(new CoreExpenseCategory(1, "FoodOthers", 1));
    	coreExpenseCategoryRepository.save(new CoreExpenseCategory(2, "Travel", 1));
    	
    	coreExpenseCategoryRepository.save(new CoreExpenseCategory(3, "Entertainment", 3));
    	coreExpenseCategoryRepository.save(new CoreExpenseCategory(4, "Study", 3));
    	coreExpenseCategoryRepository.save(new CoreExpenseCategory(5, "Events", 3));
    	coreExpenseCategoryRepository.save(new CoreExpenseCategory(6, "ForGhr", 3));
    	
    	coreExpenseCategoryRepository.save(new CoreExpenseCategory(7, "Medical", 4));
    	coreExpenseCategoryRepository.save(new CoreExpenseCategory(8, "InfrequentShopping", 4));
    	
    	coreExpenseCategoryRepository.save(new CoreExpenseCategory(9, "PPF", 5));
    	coreExpenseCategoryRepository.save(new CoreExpenseCategory(10, "NPS", 5));
    	coreExpenseCategoryRepository.save(new CoreExpenseCategory(11, "Insurance", 5));
    	coreExpenseCategoryRepository.save(new CoreExpenseCategory(12, "Donation", 5));
    	coreExpenseCategoryRepository.save(new CoreExpenseCategory(13, "ForHome", 5));
    	coreExpenseCategoryRepository.save(new CoreExpenseCategory(14, "MutualFunds", 5));
    	coreExpenseCategoryRepository.save(new CoreExpenseCategory(15, "Emergency", 5));
    	System.out.println("================================================DB Entries: {}"+ coreExpenseCategoryRepository.count());
    	
    	return "expense";
	}
	
	@RequestMapping(value="/accountCategory", method=RequestMethod.GET)
	public String prepareAccountCategory(ModelMap model){
		accountCategoryRepository.save(new AccountCategory(1, "CreditCard"));
    	accountCategoryRepository.save(new AccountCategory(2, "Debit"));
    	accountCategoryRepository.save(new AccountCategory(3, "Cash"));
    	accountCategoryRepository.save(new AccountCategory(4, "Wallet"));
    	accountCategoryRepository.save(new AccountCategory(5, "Savings"));
    	
    	System.out.println("================================================DB Entries: {}"+ accountCategoryRepository.count());
		return "expense";
	}
	
	@RequestMapping(value="/accounts", method=RequestMethod.GET)
	public String prepareAccounts(ModelMap model){
		accountRepository.save(new Account(1, "AMEXCreditCard", "CreditCard", 0));
    	accountRepository.save(new Account(2, "ICICICreditCard", "CreditCard", 0));
    	accountRepository.save(new Account(3, "HDFCCreditCard", "CreditCard", 0));
    	
    	accountRepository.save(new Account(4, "ICICIBank", "Bank", 91000));
    	
    	accountRepository.save(new Account(5, "Cash", "Cash", 0)); 
    	
    	accountRepository.save(new Account(6, "Paytm", "Wallet", 0));
    	accountRepository.save(new Account(7, "OlaMoney", "Wallet", 0));
    	accountRepository.save(new Account(8, "AmazonWallet", "Wallet", 0));
    	
    	accountRepository.save(new Account(9, "PPF", "Savings", 0));
    	accountRepository.save(new Account(10, "NPS", "Savings", 0));
    	accountRepository.save(new Account(11, "Insurance", "Savings", 0));
    	accountRepository.save(new Account(12, "Donation", "Savings", 0));
    	accountRepository.save(new Account(13, "ForHome", "Savings", 0));
    	accountRepository.save(new Account(14, "MutualFunds", "Savings", 0));
    	accountRepository.save(new Account(15, "Emergency", "Savings", 0));
    	System.out.println("================================================DB Entries: {}"+ accountRepository.count());
    	return "expense";
	}
	
	@RequestMapping(value="/expenses", method=RequestMethod.GET)
	public String dummyExpenses(ModelMap model){
		expenseRepository.save(new Expense(new Date(5,6,2018), 9000, "FoodOthers", 			"DAILY", 	"AMEXCreditCard", "CreditCard", "", false));
		expenseRepository.save(new Expense(new Date(5,6,2018), 6000, "Travel", 				"DAILY", 	"AMEXCreditCard", "CreditCard", "", false));
		expenseRepository.save(new Expense(new Date(5,6,2018), 4000, "Entertainment", 		"OPTIONAL", "ICICICreditCard", "CreditCard", "", false));
		expenseRepository.save(new Expense(new Date(5,6,2018), 2000, "Study", 				"OPTIONAL", "ICICICreditCard", "CreditCard", "", false));
		expenseRepository.save(new Expense(new Date(5,6,2018), 2000, "Events", 				"OPTIONAL", "ICICICreditCard", "CreditCard", "", false));
		expenseRepository.save(new Expense(new Date(5,6,2018), 1200, "ForGhr", 				"OPTIONAL", "ICICICreditCard", "CreditCard", "", false));
		expenseRepository.save(new Expense(new Date(5,6,2018), 3300, "Medical", 			"UNPLANNED", "AMEXCreditCard", "Bank", "", false));
		expenseRepository.save(new Expense(new Date(5,6,2018), 2000, "InfrequentShopping", 	"UNPLANNED", "AMEXCreditCard", "Bank", "", false));
		expenseRepository.save(new Expense(new Date(5,6,2018), 11800, "PPF", 				"SAVINGS", 	"ICICIBank", "Bank", "", false));
		expenseRepository.save(new Expense(new Date(5,6,2018), 5000, "NPS", 				"SAVINGS", 	"ICICIBank", "Bank", "", false));
		expenseRepository.save(new Expense(new Date(5,6,2018), 3200, "Insurance", 			"SAVINGS", 	"ICICIBank", "Bank", "", false));
		expenseRepository.save(new Expense(new Date(5,6,2018), 5000, "Donation", 			"SAVINGS", 	"ICICIBank", "Bank", "", false));
		expenseRepository.save(new Expense(new Date(5,6,2018), 20000, "ForHome", 			"SAVINGS", 	"ICICIBank", "Bank", "", false));
		expenseRepository.save(new Expense(new Date(5,6,2018), 15000, "MutualFunds", 		"SAVINGS", 	"ICICIBank", "Bank", "", false));
		expenseRepository.save(new Expense(new Date(5,6,2018), 10000, "Emergency", 			"SAVINGS", 	"ICICIBank", "Bank", "", false));
    	System.out.println("================================================DB Entries: {}"+ expenseRepository.count());
    	return "expense";
	}
	
}