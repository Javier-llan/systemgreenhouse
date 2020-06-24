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
import com.system.green.house.models.entities.ChemicalUsed;
import com.system.green.house.models.entities.TreatmentSowing;
import com.system.green.house.models.services.IChemicalAndMaterialService;
import com.system.green.house.models.services.IChemicalUsedService;
import com.system.green.house.models.services.ITreatmentSowingService;

@RequestMapping(value="/chemicalused")
@Controller
public class ChemicalUsedController {

	@Autowired
	private IChemicalUsedService srvChemicalUsed;
	
	@Autowired
	private IChemicalAndMaterialService srvChemicalAndMaterial;
	
	@Autowired
	private ITreatmentSowingService srvTreatmentSowing;
	
	@GetMapping(value="/create")
	public String create(Model model) {
		ChemicalUsed chemicalUseds = new ChemicalUsed();
		model.addAttribute("title","Register for Chemical useds");
		model.addAttribute("chemicalUsed",chemicalUseds);
		List<ChemicalAndMaterial> chemicalMaterials = srvChemicalAndMaterial.findAll();
		model.addAttribute("chemicalAndMaterials",chemicalMaterials);
		List<TreatmentSowing> treatmentSowings = srvTreatmentSowing.findAll();
		model.addAttribute("treatmentSowings",treatmentSowings);
		return "chemicalused/form";
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		ChemicalUsed chemicalUseds= srvChemicalUsed.findById(id);
		model.addAttribute("chemicalUsed", chemicalUseds);
		return "chemicalused/form";
	}
	
	@GetMapping(value="/create/{i}")
	public String create(@PathVariable(value="id")Integer id, Model model) {
		ChemicalUsed chemicalUseds = srvChemicalUsed.findById(id);
		model.addAttribute("title","Register for new Chemical used");
		model.addAttribute("chemicalUsed",chemicalUseds);
		List<ChemicalAndMaterial> chemicalAndMaterials = srvChemicalAndMaterial.findAll();
		model.addAttribute("chemicalAndMaterials",chemicalAndMaterials);
		List<TreatmentSowing> treatmentSowings = srvTreatmentSowing.findAll();
		model.addAttribute("treatmentSowings",treatmentSowings);
		return "chemicalused/form";
	}
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		ChemicalUsed chemicalUseds = srvChemicalUsed.findById(id);
		model.addAttribute("title","Register update");
		model.addAttribute("chemicalUsed",chemicalUseds);
		List<ChemicalAndMaterial> chemicalAndMaterials=srvChemicalAndMaterial.findAll();
		model.addAttribute("chemicalAndMaterials",chemicalAndMaterials);
		List<TreatmentSowing> treatmentSowings=srvTreatmentSowing.findAll();
		model.addAttribute("treatmentSowing",treatmentSowings);
		return "chemicalused/form";
	}
	

	@PostMapping(value="/save")
	public String save(@Validated ChemicalUsed chemicalUseds, BindingResult result, Model model, RedirectAttributes flash) {
		try {
			if(result.hasErrors()) {
				if(chemicalUseds.getIdChemicalUsed()==null) {
					model.addAttribute("title","New register");
				}else {
					model.addAttribute("title","Register Update");
				}
				List<ChemicalAndMaterial> chemicalAndMaterials= srvChemicalAndMaterial.findAll();
				model.addAttribute("chemicalAndMaterials",chemicalAndMaterials);
				List<TreatmentSowing> treatmentSowings= srvTreatmentSowing.findAll();
				model.addAttribute("treatmentSowing",treatmentSowings);
				return "chemicalused/form";
			}
			srvChemicalUsed.save(chemicalUseds);
			flash.addAttribute("succes","Succesfull the register was saved");
		} catch (Exception e) {
			// TODO: handle exception
		flash.addAttribute("error","Error the register can't be saved");
		}
		return "redirect:/chemicalused/list";
	}
	
	@GetMapping(value="/delete/{id}")
	public String delete(@PathVariable(value="id") Integer id, Model model, RedirectAttributes flash) {
		try {
			srvChemicalUsed.delete(id);
			flash.addAttribute("succes", "The register was deleted");
		} catch (Exception e) {
			// TODO: handle exception
			flash.addAttribute("error","The register can't be deleted");
		}
		return "redirect:/chemicalused/list";
	}
	
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<ChemicalUsed> chemicalUseds = srvChemicalUsed.findAll();
		model.addAttribute("title", "Chemical Used list");
		model.addAttribute("chemicalUseds", chemicalUseds);
		return "chemicalused/list";		
	
	}

	
}
