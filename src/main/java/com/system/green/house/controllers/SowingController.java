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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.system.green.house.models.entities.GreenHouse;
import com.system.green.house.models.entities.Plant;
import com.system.green.house.models.entities.Sowing;
import com.system.green.house.models.reporting.RptPlantsSowing;
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
	
	
	
	
	@GetMapping(value="/create/{id}")
	public String create(@PathVariable(value="id") Integer id, Model model) {
		Sowing sowings = new Sowing();
		sowings.setPlantid(id);
		model.addAttribute("title","Register for new Sowing");
		model.addAttribute("sowing", sowings);		
		List<GreenHouse> greenHousesl = srvGreenHouse.findAll();
		model.addAttribute("greenHousesl",greenHousesl);
		return "sowing/form";
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		Sowing sowings= srvSowing.findById(id);
		model.addAttribute("sowing", sowings);
		return "sowing/card";
	}
	
	
    /*
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
	
	*/
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		Sowing sowing = srvSowing.findById(id);
		model.addAttribute("title","Register update");
		model.addAttribute("sowing",sowing);
		List<Plant> plants=srvPlant.findAll();
		model.addAttribute("plants",plants);
		List<GreenHouse> greenHouses=srvGreenHouse.findAll();
		model.addAttribute("greenHouses",greenHouses);
		return "sowing/form";
	}
	

	@PostMapping(value="/save")
	public String save(@RequestBody @Validated Sowing sowings, BindingResult result, Model model, RedirectAttributes flash) {
		try {
			
				
				Plant plants = this.srvPlant.findById(sowings.getPlantid());
				sowings.setPlants(plants);
				GreenHouse greenhouses = this.srvGreenHouse.findById(sowings.getGreenhouseid());
				sowings.setGreenHouses(greenhouses);
				this.srvSowing.save(sowings);
				flash.addAttribute("succes","Succesfull the register was saved");
				return "sowing/list";
				
			
		} catch (Exception e) {
			// TODO: handle exception
		flash.addAttribute("error","Error the register can't be saved");
		}
		return "redirect:/sowing/form";
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
		model.addAttribute("title", "Lista de siembras");
		model.addAttribute("sowings", sowings);
		return "sowing/list";		
	
	}
	
	@GetMapping(value="/list/{id}")
	public String list(@PathVariable(value="id") Integer id, Model model) {
		List<Sowing> sowings = this.srvSowing.findByPlant(id);
		model.addAttribute("sowings", sowings);
		return "sowing/list";
	}
	
	@GetMapping(value = "/rptPlantsSowings")
	public String rptPlantsSowings(Model model) {
		return "sowing/rptplantsSowings";				
	}
	
	@GetMapping(value = "/dataRptPlantadosSiembras", produces="application/json")
	public @ResponseBody List<RptPlantsSowing> dataRptPlantadosSiembras(Model model) {				
		try {			
			return this.srvSowing.rptPlantadosSiembra();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}		
	}
	
}
