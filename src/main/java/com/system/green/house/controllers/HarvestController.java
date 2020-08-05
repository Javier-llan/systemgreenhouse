package com.system.green.house.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.system.green.house.models.entities.Harvest;
import com.system.green.house.models.entities.Sowing;
import com.system.green.house.models.services.IHarvestService;
import com.system.green.house.models.services.ISowingService;

@RequestMapping(value="/harvest")
@Controller
public class HarvestController {

	@Autowired
	private IHarvestService srvHarvest;
	
	@Autowired
	private ISowingService srvSowing;
	
	@GetMapping(value="/create")
	public String create(Model model) {
		Harvest harvests = new Harvest();
		model.addAttribute("harvest",harvests);
		model.addAttribute("title","Register for new Harvest");
		List<Sowing>sowings = srvSowing.findAll();
		model.addAttribute("sowings",sowings);
		return "harvest/form";
	}
	
	@GetMapping(value="/create/{id}")
	public String create(@PathVariable(value="id") Integer id, Model model) {
		Harvest harvests = new Harvest();
		model.addAttribute("harvest", harvests);
		model.addAttribute("title","Register for new Harvest");
		List<Sowing> sowings= srvSowing.findAll();
		model.addAttribute("sowing",sowings);
		
		return "harvest/form";
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		Harvest harvests = srvHarvest.findById(id);
		model.addAttribute("harvest",harvests);
		return "harvest/card";
	}
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		Harvest harvests = srvHarvest.findById(id);
		model.addAttribute("title","Actualización de registro");
		model.addAttribute("harvets",harvests);
		List<Sowing> sowings = srvSowing.findAll();
		model.addAttribute("sowings",sowings);
		return "harvest/form";
	}
	
	@PostMapping(value="/save")
	public String save(@Validated Harvest harvests, BindingResult result, Model model, RedirectAttributes flash) {
		try {
			if(result.hasErrors()) {
				if(harvests.getIdharvest()==null) {
					model.addAttribute("title","Nuevo registro");
				}else {
					model.addAttribute("title","Actualización de registro");
				}
				List<Sowing> sowings= srvSowing.findAll();
				model.addAttribute("sowings",sowings);
				
				return "harvest/form";
			}
			srvHarvest.save(harvests);
			flash.addFlashAttribute("succes","El registro fue guardado");
		} catch (Exception e) {
			// TODO: handle exception
		flash.addFlashAttribute("error","El registro no pudo ser guardado");
		}
		return "redirect:/harvest/list";
	}
	
	@GetMapping(value="/delete/{id}")
	public String delete(@PathVariable(value="id") Integer id, Model model, RedirectAttributes flash) {
		try {
			srvHarvest.delete(id);
			flash.addFlashAttribute("succes", "El registro fue eliminado");
		} catch (Exception e) {
			// TODO: handle exception
			flash.addFlashAttribute("error","El registro no pudo ser eliminado");
		}
		return "redirect:/harvest/list";
	}
	
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<Harvest> harvests = srvHarvest.findAll();
		model.addAttribute("title", "List of harvest");
		model.addAttribute("harvests", harvests);
		return "harvest/list";		
	
	}
}
