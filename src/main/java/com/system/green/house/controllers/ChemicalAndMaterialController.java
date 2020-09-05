package com.system.green.house.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
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
		model.addAttribute("title","Nuevo registro de quimicos y materiales");
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
		model.addAttribute("title","Registro actualizado");
		return "chemicalandmaterial/form";
	}
	
	@GetMapping(value="/delete/{id}")
	public String delete(@PathVariable(value="id") Integer id, Model model, RedirectAttributes flash) {
		try {
			srvChemicalAndMaterial.delete(id);
			flash.addFlashAttribute("success","El registro fue eliminado");
		} catch (Exception e) {
			flash.addFlashAttribute("error","El registro no puede ser eliminado");
		}
		
		return "redirect:/chemicalandmaterial/list";
	}
	
	
	@PostMapping(value="/save")
	public String save( ChemicalAndMaterial chemicalAndMaterials, BindingResult result,Model model,@RequestParam("photo_qm") MultipartFile image, RedirectAttributes flash ) {
try {
			
			String message = "Material o quimico agregado correctamente";
			String titulo = "Nuevo registro de Material o quimico";
			
			if(chemicalAndMaterials.getIdchemicalAndMaterial() != null) {
				message = "Material o quimico actualizado correctamente";
				titulo = "Actualizando el registro de " + chemicalAndMaterials;
			}
						
			if(result.hasErrors()) {
				model.addAttribute("title", titulo);							
				return "chemicalandmaterial/form";				
			}
			
			if (!image.isEmpty()) {				
				Path dir = Paths.get("src//main//resources//static//photos_qms");
				String rootPath = dir.toFile().getAbsolutePath();
				try {
					byte[] bytes = image.getBytes();
					Path rutaCompleta = Paths.get(rootPath + "//" + image.getOriginalFilename());
					Files.write(rutaCompleta, bytes);
				chemicalAndMaterials.setImage_chemicalmaterial(image.getOriginalFilename());

				} catch (IOException e) {
					e.printStackTrace();
				}
			}													
			srvChemicalAndMaterial.save(chemicalAndMaterials);	
			flash.addFlashAttribute("success", message);
		}
		catch(Exception ex) {
			flash.addFlashAttribute("error", ex.getMessage());
		}				
		return "redirect:/chemicalandmaterial/list";
	}
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<ChemicalAndMaterial> chemicalAndMaterials = srvChemicalAndMaterial.findAll();
		model.addAttribute("chemicalAndMaterials", chemicalAndMaterials);
		model.addAttribute("title", "Lista de quimicos y materiales");
		return "chemicalandmaterial/list";
	}
	
	@GetMapping(value="/search/{criteria}", produces="application/json")
	public @ResponseBody List<ChemicalAndMaterial> search(@PathVariable(value="criteria") String criteria, Model model){
		List<ChemicalAndMaterial> lista = this.srvChemicalAndMaterial.findByName(criteria);
		return lista;
	}
}
