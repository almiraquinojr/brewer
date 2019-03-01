package com.almiraquino.brewer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.almiraquino.brewer.model.User;

@Controller
@RequestMapping("/users")
public class UsersController {
	
	@RequestMapping("/new")
	public String newCustomer(User user) {
		return "user/add-user";
	}

}
