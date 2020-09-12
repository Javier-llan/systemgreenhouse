package com.system.green.house.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.system.green.house.models.entities.UsedMaterial;
import com.system.green.house.models.reporting.RptUsedsMaterials;
import com.system.green.house.models.reporting.RptUserMaintenanceCreadoPor;
import com.system.green.house.models.services.UsedMaterialService;


@RequestMapping(value="/usedmaterial")
@Controller
public class UsedMaterialController {
	
	@Autowired
	private UsedMaterialService srvUsedMaterial;

	@GetMapping(value="/create")
	public String create(Model model) {
		UsedMaterial usedmaterial = new UsedMaterial();
		model.addAttribute("usedmaterial",usedmaterial);
		return "usedmaterial/form";
	}
	
	@GetMapping(value="/delete/{id}")
	public String delete(@PathVariable(value="id") Integer id, Model model) {
		UsedMaterial materials = this.srvUsedMaterial.findById(id);
		int idmaintenance = materials.getMaintenanceid();
		this.srvUsedMaterial.delete(id);
		return "redirect:/usedmaterial/list/"+idmaintenance;
	}
	
	@GetMapping(value="/rptUserMaintenanceCreadoPor")
	public String rptUserMaintenanceCreadoPor(Model model) {
		return "usedmaterial/rptUserMaintenanceCreadoPor";
	}
	
	@GetMapping(value = "/dataRptUserMaintenanceCreadoPor", produces="application/json")
	public @ResponseBody List<RptUserMaintenanceCreadoPor>dataRptUserMaintenanceCreadoPor(Model model){
		try {
			return this.srvUsedMaterial.rptUserMaintenanceCreadoPors();
			
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}
	
	@GetMapping(value = "/rptMaterialUsado")
	public String rptMaterialUsado(Model model) {
		return "usedmaterial/rptMaterialUsado";				
	}
	
	@GetMapping(value = "/dataRptMaterialesUsados", produces="application/json")
	public @ResponseBody List<RptUsedsMaterials> dataRptMaterialesUsados(Model model) {				
		try {			
			return this.srvUsedMaterial.rptMaterialesUsados();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}		
	}
}
