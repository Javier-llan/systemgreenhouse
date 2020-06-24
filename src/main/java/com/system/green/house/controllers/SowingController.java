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

import com.system.green.house.models.entities.GreenHouse;
import com.system.green.house.models.entities.Plant;
import com.system.green.house.models.entities.Sowing;
import com.system.green.house.models.services.IGreenHouseService;
import com.system.green.house.models.services.IPlantService;
import com.system.green.house.models.services.ISowingService;

@RequestMapping(value="/sowing")
@Controller
public class SowingController {
	@Autowired
	private ISowingService srvSowing;
	
	@Autowired
	private IPlantService srvPlant;
	
	@Autowired
	private IGreenHouseService srvGreenHouse;
	
	@GetMapping(value="/create")
	public String create(Model model) {
		Sowing sowings = new Sowing();
		model.addAttribute("title","Register for new Sowing");
		model.addAttribute("sowing",sowings);
		List<Plant> plants = srvPlant.findAll();
		model.addAttribute("plants",plants);
		List<GreenHouse> greenHouses = srvGreenHouse.findAll();
		model.addAttribute("greenhouses",greenHouses);
		return "sowing/form";
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		Sowing sowings= srvSowing.findById(id);
		model.addAttribute("sowing", sowings);
		return "sowing/form";
	}
	
	@GetMapping(value="/create/{i}")
	public String create(@PathVariable(value="id")Integer id, Model model) {
		Sowing sowings = srvSowing.findById(id);
		model.addAttribute("title","Register for new Sowing");
		model.addAttribute("sowing",sowings);
		List<Plant> plants = srvPlant.findAll();
		model.addAttribute("plants",plants);
		List<GreenHouse> greenHouses = srvGreenHouse.findAll();
		model.addAttribute("greenHouses",greenHouses);
		return "sowing/form";
	}
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		Sowing sowing = srvSowing.findById(id);
		model.addAttribute("title","Register update");
		model.addAttribute("sowing",sowing);
		List<Plant> plants=srvPlant.findAll();
		model.addAttribute("plants",plants);
		List<GreenHouse> greenHouses=srvGreenHouse.findAll();
		model.addAttribute("greenHouses",greenHouses);
		return "greenhouse/form";
	}
	

	@PostMapping(value="/save")
	public String save(@Validated Sowing sowings, BindingResult result, Model model, RedirectAttributes flash) {
		try {
			if(result.hasErrors()) {
				if(sowings.getIdsowing()==null) {
					model.addAttribute("title","New register");
				}else {
					model.addAttribute("title","Register Update");
				}
				List<Plant> plants= srvPlant.findAll();
				model.addAttribute("plants",plants);
				List<GreenHouse> greenHouses= srvGreenHouse.findAll();
				model.addAttribute("greenHouses",greenHouses);
				return "greenhouse/form";
			}
			srvSowing.save(sowings);
			flash.addAttribute("succes","Succesfull the register was saved");
		} catch (Exception e) {
			// TODO: handle exception
		flash.addAttribute("error","Error the register can't be saved");
		}
		return "redirect:/sowing/list";
	}
	
	@GetMapping(value="/delete/{id}")
	public String delete(@PathVariable(value="id") Integer id, Model model, RedirectAttributes flash) {
		try {
			srvSowing.delete(id);
			flash.addAttribute("succes", "The register was deleted");
		} catch (Exception e) {
			// TODO: handle exception
			flash.addAttribute("error","The register can't be deleted");
		}
		return "redirect:/sowing/list";
	}
	
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<Sowing> sowings = srvSowing.findAll();
		model.addAttribute("title", "Sowing list");
		model.addAttribute("sowings", sowings);
		return "sowing/list";		
	
	}
	
}
