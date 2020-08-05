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
import com.system.green.house.models.entities.MaintenanceGreenHouse;
import com.system.green.house.models.services.IGreenHouseService;
import com.system.green.house.models.services.IMaintenanceGreenHouseService;

@RequestMapping(value="/maintenancegreenhouse")
@Controller
public class MaintenanceGreenHouseController {

	@Autowired
	private IMaintenanceGreenHouseService srvMaintenanceGreenHouse;
	
	@Autowired
	private IGreenHouseService srvGreenHouse;
	
	
	@GetMapping(value="/create")
	public String create(Model model) {
		MaintenanceGreenHouse maintenanceGreenHouses = new MaintenanceGreenHouse();
		model.addAttribute("title","Registro de nuevo mantenimiento");
		model.addAttribute("maintenanceGreenHouse",maintenanceGreenHouses);
		List<GreenHouse> greenHouses = srvGreenHouse.findAll();
		model.addAttribute("greenHouses",greenHouses);
		return "maintenancegreenhouse/form";
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		MaintenanceGreenHouse maintenanceGreenHouses= srvMaintenanceGreenHouse.findById(id);
		model.addAttribute("maintenanceGreenHouse", maintenanceGreenHouses);
		return "maintenancegreenhouse/card";
	}
	
	@GetMapping(value="/create/{i}")
	public String create(@PathVariable(value="id")Integer id, Model model) {
		MaintenanceGreenHouse maintenanceGreenHouses = srvMaintenanceGreenHouse.findById(id);
		model.addAttribute("title","Registro de nuevo mantenimiento");
		model.addAttribute("maintenanceGreenHouse",maintenanceGreenHouses);
		List<GreenHouse> greenHouses = srvGreenHouse.findAll();
		model.addAttribute("greenHouses", greenHouses);
		return "maintenancegreenhouse/form";
	}
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		MaintenanceGreenHouse maintenanceGreenHouses = srvMaintenanceGreenHouse.findById(id);
		model.addAttribute("title","Actualización de Registro");
		model.addAttribute("maintenanceGreenHouse",maintenanceGreenHouses);
		List<GreenHouse> greenHouses=srvGreenHouse.findAll();
		model.addAttribute("greenHouses",greenHouses);
		return "maintenancegreenhouse/form";
	}
	

	@PostMapping(value="/save")
	public String save(@Validated MaintenanceGreenHouse maintenanceGreenHouses, BindingResult result, Model model, RedirectAttributes flash) {
try {
			
			String message = "Mantenimiento agregado correctamente";
			String titulo = "Nuevo registro de Mantenimiento";
			
			if(maintenanceGreenHouses.getIdMaintenaceGreenHouse() != null) {
				message = "Mantenimiento actualizado correctamente";
				titulo = "Actualizando el registro de " + maintenanceGreenHouses;
			}
						
			if(result.hasErrors()) {
				model.addAttribute("title", titulo);
				List<GreenHouse> greenHouses= srvGreenHouse.findAll();
				model.addAttribute("greenHouse",greenHouses);
				return "maintenancegreenhouse/form";				
			}
			
														
			srvMaintenanceGreenHouse.save(maintenanceGreenHouses);	
			flash.addFlashAttribute("success", message);
		}
		catch(Exception ex) {
			flash.addFlashAttribute("error", ex.getMessage());
		}				
		return "redirect:/maintenancegreenhouse/list";
	}
	
	@GetMapping(value="/delete/{id}")
	public String delete(@PathVariable(value="id") Integer id, Model model, RedirectAttributes flash) {
		try {
			srvMaintenanceGreenHouse.delete(id);
			flash.addFlashAttribute("success","El registro fue eliminado");
		} catch (Exception e) {
			flash.addFlashAttribute("error","El registro no puede ser eliminado");
		}
		
		return "redirect:/maintenancegreenhouse/list";
	}
	
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<MaintenanceGreenHouse> maintenanceGreenHouses = srvMaintenanceGreenHouse.findAll();
		model.addAttribute("title", "Lista de Mantenimientos");
		model.addAttribute("maintenanceGreenHouses", maintenanceGreenHouses);
		return "maintenancegreenhouse/list";		
	
	}
}
