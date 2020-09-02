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

import com.system.green.house.models.entities.ChemicalAndMaterial;
import com.system.green.house.models.entities.MaintenanceGreenHouse;
import com.system.green.house.models.entities.UsedMaterial;
import com.system.green.house.models.services.ChemicalAndMaterialService;
import com.system.green.house.models.services.MaintenanceGreenHouseService;
import com.system.green.house.models.services.UsedMaterialService;

@RequestMapping(value="/usedmaterial")
@Controller
public class UsedMaterialController {

	@Autowired
	private UsedMaterialService srvUsedMaterial;
	
	@Autowired
	private ChemicalAndMaterialService srvChemicalAndMaterial;
	
	@Autowired
	private MaintenanceGreenHouseService srvMaintenanceGreenHouse;
	
	@GetMapping(value="/create")
	public String create(Model model) {
		UsedMaterial usedMaterials = new UsedMaterial();
		model.addAttribute("title","Registro de materiales y quimicos usados");
		model.addAttribute("usedMaterial",usedMaterials);
		List<ChemicalAndMaterial> chemicalMaterials = srvChemicalAndMaterial.findAll();
		model.addAttribute("chemicalAndMaterials",chemicalMaterials);
		List<MaintenanceGreenHouse> maintenanceGreenHouses = srvMaintenanceGreenHouse.findAll();
		model.addAttribute("maintenanceGreenHouses",maintenanceGreenHouses);
		return "usedmaterial/form";
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		UsedMaterial usedMaterials= srvUsedMaterial.findById(id);
		model.addAttribute("usedMaterial", usedMaterials);
		return "usedmaterial/card";
	}
	
	@GetMapping(value="/create/{i}")
	public String create(@PathVariable(value="id")Integer id, Model model) {
		UsedMaterial usedMaterials = srvUsedMaterial.findById(id);
		model.addAttribute("title","Registro para nuevo material y quimico");
		model.addAttribute("usedMaterial",usedMaterials);
		List<ChemicalAndMaterial> chemicalAndMaterials = srvChemicalAndMaterial.findAll();
		model.addAttribute("chemicalAndMaterials",chemicalAndMaterials);
		List<MaintenanceGreenHouse> maintenanceGreenHouses = srvMaintenanceGreenHouse.findAll();
		model.addAttribute(" maintenanceGreenHouses", maintenanceGreenHouses);
		return "usedmaterial/form";
	}
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		UsedMaterial usedMaterials = srvUsedMaterial.findById(id);
		model.addAttribute("title","Actualización  de Registro");
		model.addAttribute("usedMaterial",usedMaterials);
		List<ChemicalAndMaterial> chemicalAndMaterials=srvChemicalAndMaterial.findAll();
		model.addAttribute("chemicalAndMaterials",chemicalAndMaterials);
		List<MaintenanceGreenHouse> maintenanceGreenHouses=srvMaintenanceGreenHouse.findAll();
		model.addAttribute("maintenanceGreenHouses",maintenanceGreenHouses);
		return "usedmaterial/form";
	}
	

	@PostMapping(value="/save")
	public String save(@Validated UsedMaterial usedMaterials, BindingResult result, Model model, RedirectAttributes flash) {
try {
			
			String message = "Material usado agregado correctamente";
			String titulo = "Nuevo registro de usos de materiales";
			
			if(usedMaterials.getIdMaterialUsed() != null) {
				message = "Mantenimiento actualizado correctamente";
				titulo = "Actualizando el registro de " + usedMaterials;
			}
						
			if(result.hasErrors()) {
				model.addAttribute("title", titulo);
				List<ChemicalAndMaterial> chemicalAndMaterials= srvChemicalAndMaterial.findAll();
				model.addAttribute("chemicalAndMaterials",chemicalAndMaterials);
				List<MaintenanceGreenHouse> maintenanceGreenHouses= srvMaintenanceGreenHouse.findAll();
				model.addAttribute(" maintenanceGreenHouses",maintenanceGreenHouses);
				return "usedmaterial/form";			
			}
			
														
			srvUsedMaterial.save(usedMaterials);	
			flash.addFlashAttribute("success", message);
		}
		catch(Exception ex) {
			flash.addFlashAttribute("error", ex.getMessage());
		}				
		return "redirect:/usedmaterial/list";
	}
	
	@GetMapping(value="/delete/{id}")
	public String delete(@PathVariable(value="id") Integer id, Model model, RedirectAttributes flash) {
		try {
			srvUsedMaterial.delete(id);
			flash.addFlashAttribute("success","El registro fue eliminado");
		} catch (Exception e) {
			flash.addFlashAttribute("error","El registro no puede ser eliminado");
		}
		
		return "redirect:/usedmaterial/list";
	}
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<UsedMaterial> usedMaterials = srvUsedMaterial.findAll();
		model.addAttribute("title", "Lista de materiales usados");
		model.addAttribute("usedMaterials", usedMaterials);
		return "usedmaterial/list";		
	
	}
}
