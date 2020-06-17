package com.system.green.house.models.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/")
public class HomeController {
	@GetMapping(value="/home.html")
	public String home(Model model) {
		model.addAttribute("framework","Spring Boot");
		model.addAttribute("main","Ejercicio Práctico");
		model.addAttribute("description","Front - End");
		return "home";
	}
}
