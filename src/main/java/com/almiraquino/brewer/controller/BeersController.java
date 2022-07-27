package com.almiraquino.brewer.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.validation.Valid;

import com.almiraquino.brewer.model.Beer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/beers")
public class BeersController {
	
	List<Beer> beers = new ArrayList<>(Arrays.asList(
		new Beer().withSku("12345").withName("Guinness").withDescription("Irish Stout"),
		new Beer().withSku("54321").withName("Coors Light").withDescription("American Light Lager")
	));
	
	@GetMapping("/new")
	public String newBeer(Model model) {
		model.addAttribute("beer", new Beer());
		return "beer/add-beer";
	}
	
	@PostMapping("/new")
	public String newBeer(@Valid Beer beer, Model model) {
		model.addAttribute("beer", beer);
		beers.add(beer);
		System.out.println("beer count = " + beers.size());
		return "beer/add-beer";
	}
	
	@GetMapping(value = "/list")
	public String list(@RequestParam String sort, Model model) {
		System.out.println("sort: "+sort);
		model.addAttribute("beers", beers);
		return "beer/list";
	}

}
