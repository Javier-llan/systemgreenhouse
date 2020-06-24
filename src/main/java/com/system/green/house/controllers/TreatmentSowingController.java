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


import com.system.green.house.models.entities.Sowing;
import com.system.green.house.models.entities.TreatmentSowing;
import com.system.green.house.models.services.ISowingService;
import com.system.green.house.models.services.ITreatmentSowingService;

@RequestMapping(value="treatmentsowing")
@Controller
public class TreatmentSowingController {

	@Autowired
	private ITreatmentSowingService srvTreatmentSowing;
	
	@Autowired
	private ISowingService srvSowing;
	
	@GetMapping(value="/create")
	public String create(Model model) {
		TreatmentSowing treatmentSowings = new TreatmentSowing();
		model.addAttribute("title","Register for Chemical useds");
		model.addAttribute("treatmentSowing",treatmentSowings);
		List<Sowing> sowings = srvSowing.findAll();
		model.addAttribute("sowings",sowings);
		return "treatmentsowing/form";
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		TreatmentSowing treatmentSowings= srvTreatmentSowing.findById(id);
		model.addAttribute("treatmentSowing", treatmentSowings);
		return "treatmentsowing/form";
	}
	
	@GetMapping(value="/create/{i}")
	public String create(@PathVariable(value="id")Integer id, Model model) {
		TreatmentSowing treatmentSowings = srvTreatmentSowing.findById(id);
		model.addAttribute("title","Register for new Chemical used");
		model.addAttribute("treatmentSowing",treatmentSowings);
		List<Sowing> sowings = srvSowing.findAll();
		model.addAttribute("sowings", sowings);
		return "treatmentsowing/form";
	}
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		TreatmentSowing treatmentSowings = srvTreatmentSowing.findById(id);
		model.addAttribute("title","Register update");
		model.addAttribute("treatmentSowing",treatmentSowings);
		List<Sowing> sowings=srvSowing.findAll();
		model.addAttribute("sowings",sowings);
		return "treatmentsowing/form";
	}
	

	@PostMapping(value="/save")
	public String save(@Validated TreatmentSowing treatmentSowings, BindingResult result, Model model, RedirectAttributes flash) {
		try {
			if(result.hasErrors()) {
				if(treatmentSowings.getIdtreatment_swoing()==null) {
					model.addAttribute("title","New register");
				}else {
					model.addAttribute("title","Register Update");
				}
				List<Sowing> sowings= srvSowing.findAll();
				model.addAttribute("sowings",sowings);
				return "treatmentsowing/form";
			}
			srvTreatmentSowing.save(treatmentSowings);
			flash.addAttribute("succes","Succesfull the register was saved");
		} catch (Exception e) {
			// TODO: handle exception
		flash.addAttribute("error","Error the register can't be saved");
		}
		return "redirect:/treatmentsowing/list";
	}
	
	@GetMapping(value="/delete/{id}")
	public String delete(@PathVariable(value="id") Integer id, Model model, RedirectAttributes flash) {
		try {
			srvTreatmentSowing.delete(id);
			flash.addAttribute("succes", "The register was deleted");
		} catch (Exception e) {
			// TODO: handle exception
			flash.addAttribute("error","The register can't be deleted");
		}
		return "redirect:/treatmentsowing/list";
	}
	
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<TreatmentSowing> treatmentSowings = srvTreatmentSowing.findAll();
		model.addAttribute("title", "Chemical Used list");
		model.addAttribute("treatmentSowing", treatmentSowings);
		return "treatmentsowing/list";		
	
	}

}
