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

import com.system.green.house.models.entities.GreenHouse;
import com.system.green.house.models.services.IGreenHouseService;

@RequestMapping(value="/greenhouse")
@Controller
public class GreenHouseController {
	@Autowired
	private IGreenHouseService srvGreenHouse;
	
	@GetMapping(value="/create")
	public String create(Model model) {
		GreenHouse greenHouses = new GreenHouse();
		model.addAttribute("title", "Register for new Green House");
		model.addAttribute("greenHouse",greenHouses);
		return "greenhouse/form";	
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		GreenHouse greenHouses = srvGreenHouse.findById(id);
		model.addAttribute("greenHouse",greenHouses);
		return "greenhouse/card";
	}
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		GreenHouse greenHouses = srvGreenHouse.findById(id);
		model.addAttribute("greenHouse", greenHouses);
		model.addAttribute("title","Actualizando registro");
		return "greenhouse/form";
	}
	
	@GetMapping(value="/delete/{id}")
	public String delete(@PathVariable(value="id") Integer id, Model model, RedirectAttributes flash) {
		try {
			srvGreenHouse.delete(id);
			flash.addAttribute("success","El registo fue eliminado");
		} catch (Exception e) {
			flash.addAttribute("error","El registro no pudo ser eliminado");
		}
		
		return "redirect:/greenhouse/list";
	}
	
	@PostMapping(value="/save")
	public String save( GreenHouse greenHouses, BindingResult result,Model model, RedirectAttributes flash ) {
		try {
			if(result.hasErrors()) {
				if(greenHouses.getIdgreenHouse()==null) {
					model.addAttribute("title","Nuevo registro");
				}else {
					model.addAttribute("title","Actulización del registro");
				}
				return "greenhouse/form";
			}
			srvGreenHouse.save(greenHouses);
			flash.addAttribute("succes","El registro fue guardado con éxito ");
		} catch (Exception e) {
			// TODO: handle exception
			flash.addAttribute("error", "El registro no pudo ser guardado");
		}
		return "redirect:/greenhouse/list";
	}
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<GreenHouse> greenHouses = srvGreenHouse.findAll();
		model.addAttribute("greenHouses", greenHouses);
		model.addAttribute("title", "List of Green Houses");
		return "greenhouse/list";
	}
}
