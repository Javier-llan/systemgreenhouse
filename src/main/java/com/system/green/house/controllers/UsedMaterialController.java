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
		model.addAttribute("title","Register for Chemical useds");
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
		return "usedmaterial/form";
	}
	
	@GetMapping(value="/create/{i}")
	public String create(@PathVariable(value="id")Integer id, Model model) {
		UsedMaterial usedMaterials = srvUsedMaterial.findById(id);
		model.addAttribute("title","Register for new Chemical used");
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
		model.addAttribute("title","Register update");
		model.addAttribute("chemicalUsed",usedMaterials);
		List<ChemicalAndMaterial> chemicalAndMaterials=srvChemicalAndMaterial.findAll();
		model.addAttribute("chemicalAndMaterials",chemicalAndMaterials);
		List<MaintenanceGreenHouse> maintenanceGreenHouses=srvMaintenanceGreenHouse.findAll();
		model.addAttribute(" maintenanceGreenHouses",maintenanceGreenHouses);
		return "usedmaterial/form";
	}
	

	@PostMapping(value="/save")
	public String save(@Validated UsedMaterial usedMaterials, BindingResult result, Model model, RedirectAttributes flash) {
		try {
			if(result.hasErrors()) {
				if(usedMaterials.getIdMaterialUsed()==null) {
					model.addAttribute("title","New register");
				}else {
					model.addAttribute("title","Register Update");
				}
				List<ChemicalAndMaterial> chemicalAndMaterials= srvChemicalAndMaterial.findAll();
				model.addAttribute("chemicalAndMaterials",chemicalAndMaterials);
				List<MaintenanceGreenHouse> maintenanceGreenHouses= srvMaintenanceGreenHouse.findAll();
				model.addAttribute(" maintenanceGreenHouses",maintenanceGreenHouses);
				return "usedmaterial/form";
			}
			srvUsedMaterial.save(usedMaterials);
			flash.addAttribute("succes","Succesfull the register was saved");
		} catch (Exception e) {
			// TODO: handle exception
		flash.addAttribute("error","Error the register can't be saved");
		}
		return "redirect:/usedmaterial/list";
	}
	
	@GetMapping(value="/delete/{id}")
	public String delete(@PathVariable(value="id") Integer id, Model model, RedirectAttributes flash) {
		try {
			srvUsedMaterial.delete(id);
			flash.addAttribute("succes", "The register was deleted");
		} catch (Exception e) {
			// TODO: handle exception
			flash.addAttribute("error","The register can't be deleted");
		}
		return "redirect:/usedmaterial/list";
	}
	
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<UsedMaterial> usedMaterials = srvUsedMaterial.findAll();
		model.addAttribute("title", "Chemical Used list");
		model.addAttribute("usedMaterials", usedMaterials);
		return "usedmaterial/list";		
	
	}
}
