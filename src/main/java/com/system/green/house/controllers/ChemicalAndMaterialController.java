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


import com.system.green.house.models.entities.ChemicalAndMaterial;
import com.system.green.house.models.services.IChemicalAndMaterialService;

@RequestMapping(value="/chemicalandmaterial")
@Controller
public class ChemicalAndMaterialController {

	@Autowired
	private IChemicalAndMaterialService srvChemicalAndMaterial;
	
	@GetMapping(value="/create")
	public String create(Model model) {
		ChemicalAndMaterial chemicalAndMaterials = new ChemicalAndMaterial();
		model.addAttribute("title","New Record for Chemical and Materials");
		model.addAttribute("chemicalAndMaterial",chemicalAndMaterials);
		return "chemicalandmaterial/form";
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		ChemicalAndMaterial chemicalAndMaterials  = srvChemicalAndMaterial.findById(id);
		model.addAttribute("chemicalAndMaterial",chemicalAndMaterials);
		return "chemicalandmaterial/card";
	}
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		ChemicalAndMaterial chemicalAndMaterials = srvChemicalAndMaterial.findById(id);
		model.addAttribute("chemicalAndMaterial", chemicalAndMaterials);
		model.addAttribute("title","Register update");
		return "chemicalandmaterial/form";
	}
	
	@GetMapping(value="/delete/{id}")
	public String delete(@PathVariable(value="id") Integer id, Model model, RedirectAttributes flash) {
		try {
			srvChemicalAndMaterial.delete(id);
			flash.addAttribute("success","The record was deleted");
		} catch (Exception e) {
			flash.addAttribute("error","The record cannot be deleted");
		}
		
		return "redirect:/chemicalandmaterial/list";
	}
	
	@PostMapping(value="/save")
	public String save( ChemicalAndMaterial chemicalAndMaterials, BindingResult result,Model model, RedirectAttributes flash ) {
		try {
			if(result.hasErrors()) {
				if(chemicalAndMaterials.getIdchemicalandmaterial()==null) {
					model.addAttribute("title","New record");
				}else {
					model.addAttribute("title","Update Record");
				}
				return "chemicalandmaterial/form";
			}
			srvChemicalAndMaterial.save(chemicalAndMaterials);
			flash.addAttribute("succes","The record was saved successfull ");
		} catch (Exception e) {
			// TODO: handle exception
			flash.addAttribute("error", "The record cannot be saved");
		}
		return "redirect:/chemicalandmaterial/list";
	}
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<ChemicalAndMaterial> chemicalAndMaterials = srvChemicalAndMaterial.findAll();
		model.addAttribute("chemicalAndMaterials", chemicalAndMaterials);
		model.addAttribute("title", "List of Chemical and Materials");
		return "chemicalandmaterial/list";
	}
}
