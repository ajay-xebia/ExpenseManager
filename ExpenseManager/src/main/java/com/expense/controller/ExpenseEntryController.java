package com.expense.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/expense")
public class ExpenseEntryController {

	@RequestMapping(value="/entries", method=RequestMethod.GET)
    public String showLoginPage(ModelMap model){
        return "expense";
    }

}