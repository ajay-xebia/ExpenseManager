package com.expense.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.expense.bean.CoreExpenseCategory;
import com.expense.bean.GeneralExpenseCategory;
import com.expense.repository.CoreExpenseCategoryRepository;
import com.expense.repository.GeneralExpenseCategoryRepository;

@Controller
@RequestMapping("/data")
public class AppDataController {
	
	private final GeneralExpenseCategoryRepository generalExpenseCategoryRepository;
	private final CoreExpenseCategoryRepository coreExpenseCategoryRepository;
	
	@Autowired
	public AppDataController(GeneralExpenseCategoryRepository generalExpenseCategoryRepository, 
			CoreExpenseCategoryRepository coreExpenseCategoryRepository) {
		this.generalExpenseCategoryRepository = generalExpenseCategoryRepository;
		this.coreExpenseCategoryRepository=coreExpenseCategoryRepository;
	}
	
	@RequestMapping(value="", method=RequestMethod.GET)
    public String prepareApp(ModelMap model){
		generalExpenseCategoryRepository.save(new GeneralExpenseCategory(1, "DAILY"));
    	generalExpenseCategoryRepository.save(new GeneralExpenseCategory(2, "MONTHLY"));
    	generalExpenseCategoryRepository.save(new GeneralExpenseCategory(3, "OPTIONAL"));
    	generalExpenseCategoryRepository.save(new GeneralExpenseCategory(4, "UNPLANNED"));
    	generalExpenseCategoryRepository.save(new GeneralExpenseCategory(5, "SAVINGS"));
    	System.out.println("================================================DB Entries: {}"+ generalExpenseCategoryRepository.count());
        
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

}