package com.system.green.house.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.system.green.house.models.entities.Plant;
import com.system.green.house.models.services.IPlantService;

@RequestMapping(value="/plant")
@Controller
public class PlantController {
	
	@Autowired
	private IPlantService srvPlant;
	
	@GetMapping(value="/create")
	public String create(Model model) {
		Plant plants = new Plant();
		model.addAttribute("title","New Record for plant");
		model.addAttribute("plant",plants);
		return "plant/form";
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		Plant plants = srvPlant.findById(id);
		model.addAttribute("plant",plants);
		return "plant/card";
	}
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		Plant plants = srvPlant.findById(id);
		model.addAttribute("plant", plants);
		model.addAttribute("title","Register update");
		return "plant/form";
	}
	
	@GetMapping(value="/delete/{id}")
	public String delete(@PathVariable(value="id") Integer id, Model model, RedirectAttributes flash) {
		try {
			srvPlant.delete(id);
			flash.addAttribute("success","The record was deleted");
		} catch (Exception e) {
			flash.addAttribute("error","The record cannot be deleted");
		}
		
		return "redirect:/plant/list";
	}
	
	@PostMapping(value="/save")
	public String save( Plant plants, BindingResult result,Model model, RedirectAttributes flash ) {
		try {
			if(result.hasErrors()) {
				if(plants.getIdplant()==null) {
					model.addAttribute("title","New record");
				}else {
					model.addAttribute("title","Update Record");
				}
				return "plant/form";
			}
			srvPlant.save(plants);
			flash.addAttribute("succes","The record was saved successfull ");
		} catch (Exception e) {
			// TODO: handle exception
			flash.addAttribute("error", "The record cannot be saved");
		}
		return "redirect:/plant/list";
	}
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<Plant> plants = srvPlant.findAll();
		model.addAttribute("plants", plants);
		model.addAttribute("title", "List of Plants");
		return "plant/list";
	}
}
