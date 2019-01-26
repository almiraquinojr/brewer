package com.almiraquino.brewer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping("/")
	public String newBeer(Model model) {
		model.addAttribute("message", "Hello Spring MVC 5!");
		return "index";
	}

}
