package com.system.green.house.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
@Controller
public class HomeController {
	@GetMapping(value="/")
	public String home(Model model) {
		model.addAttribute("framework","Spring Boot");
		model.addAttribute("main","Taller en clases");
		model.addAttribute("description","Front - End");
		return "home";
	}
}
