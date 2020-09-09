package com.system.green.house.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.system.green.house.models.entities.ChemicalAndMaterial;
import com.system.green.house.models.entities.GreenHouse;
import com.system.green.house.models.entities.MaintenanceGreenHouse;
import com.system.green.house.models.entities.UsedMaterial;
import com.system.green.house.models.services.IChemicalAndMaterialService;
import com.system.green.house.models.services.IGreenHouseService;
import com.system.green.house.models.services.IMaintenanceGreenHouseService;

@SessionAttributes("MaintenanceGreenHouse")
@RequestMapping(value="/maintenancegreenhouse")
@Controller
public class MaintenanceGreenHouseController {

	@Autowired
	private IMaintenanceGreenHouseService srvMaintenanceGreenHouse;
	
	@Autowired
	private IGreenHouseService srvGreenHouse;
	
	@Autowired
	private IChemicalAndMaterialService srvChemicalAndMaterial;
	
	
	@GetMapping(value="/create")
	public String create(Model model) {
		MaintenanceGreenHouse maintenanceGreenHouses = new MaintenanceGreenHouse();
		maintenanceGreenHouses.setUsedMaterial(new ArrayList<UsedMaterial>());
		model.addAttribute("title","Registro de mantenimiento");
		model.addAttribute("MaintenanceGreenHouse",maintenanceGreenHouses);
		List<GreenHouse> greenHouses = srvGreenHouse.findAll();
		model.addAttribute("GreenHouse", greenHouses);
		return "maintenancegreenhouse/form";
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		MaintenanceGreenHouse maintenanceGreenHouses= srvMaintenanceGreenHouse.findById(id);
		model.addAttribute("MaintenanceGreenHouse", maintenanceGreenHouses);
		return "maintenancegreenhouse/card";
	}
	
	
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		MaintenanceGreenHouse maintenanceGreenHouses = srvMaintenanceGreenHouse.findById(id);
		model.addAttribute("title","Actualización de Registro");
		model.addAttribute("MaintenanceGreenHouse",maintenanceGreenHouses);
		List<GreenHouse> greenHouses=srvGreenHouse.findAll();
		model.addAttribute("greenHouses",greenHouses);
		return "maintenancegreenhouse/form";
	}
	

	@PostMapping(value="/save")
	public String save(@Validated MaintenanceGreenHouse maintenanceGreenHouses,BindingResult result, Model model, 
			
			SessionStatus status, RedirectAttributes flash, HttpSession session) {
	try {
			
			String message = "Mantenimiento agregado correctamente";
			String titulo = "Nuevo registro de Mantenimiento";
			
			if(maintenanceGreenHouses.getIdMaintenaceGreenHouse() != null) {
				message = "Mantenimiento actualizado correctamente";
				titulo = "Actualizando el registro";
			}
						
			if(result.hasErrors()) {
				model.addAttribute("title", titulo);
				model.addAttribute("error", "Error agregar Mantenimiento");
				List<GreenHouse> greenHouses= srvGreenHouse.findAll();
				model.addAttribute("greenHouse",greenHouses);
				return "maintenancegreenhouse/form";				
			}
			
			MaintenanceGreenHouse maintenanceSession = (MaintenanceGreenHouse)	 session.getAttribute("MaintenanceGreenHouse");
			for(UsedMaterial um : maintenanceSession.getUsedMaterial()) {
				maintenanceGreenHouses.getUsedMaterial().add(um);
			}
			
			srvMaintenanceGreenHouse.save(maintenanceGreenHouses);	
			status.setComplete();
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
		model.addAttribute("MaintenanceGreenHouse", maintenanceGreenHouses);
		return "maintenancegreenhouse/list";		
	
	}
	@PostMapping(value="/add", produces="application/json")
	public @ResponseBody Object add(@RequestBody @Valid UsedMaterial usedmaterials, Model model, HttpSession session) {
		try {
			ChemicalAndMaterial materials = this.srvChemicalAndMaterial.findById(usedmaterials.getMaterialid());
			usedmaterials.setMaterialsGreenHouse(materials);
			MaintenanceGreenHouse maintenances = (MaintenanceGreenHouse) session.getAttribute("MaintenanceGreenHouse");
			maintenances.getUsedMaterial().add(usedmaterials);
			return usedmaterials;
			
		} catch (Exception ex) {
			// TODO: handle exception
			return ex;
		}
	}
	
	@GetMapping(value = "/items")
	public String items(Model model, HttpSession session) {
		MaintenanceGreenHouse mantenimientos=(MaintenanceGreenHouse) session.getAttribute("MaintenanceGreenHouse");
		model.addAttribute("usedMaterial",mantenimientos.getUsedMaterial());	
		model.addAttribute("title", "Listado de materiales");
		return "usedmaterial/list";
	}
}
