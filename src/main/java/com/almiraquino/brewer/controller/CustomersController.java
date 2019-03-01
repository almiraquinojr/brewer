package com.almiraquino.brewer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.almiraquino.brewer.model.Customer;

@Controller
@RequestMapping("/customers")
public class CustomersController {
	
	@RequestMapping("/new")
	public String newCustomer(Customer customer) {
		return "customer/add-customer";
	}

}
