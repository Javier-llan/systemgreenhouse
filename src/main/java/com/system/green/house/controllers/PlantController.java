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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.system.green.house.models.entities.Plant;
import com.system.green.house.models.services.IPlantService;


@RequestMapping(value="/plant")
@Controller
public class PlantController {
	
	@Autowired
	private IPlantService srvPlant;
	
	@GetMapping(value="/create")
	public String create(Model model) {
		Plant plants = new Plant();
		model.addAttribute("title","Nuevo registro para planta");
		model.addAttribute("plant",plants);
		return "plant/form";
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		Plant plants = srvPlant.findById(id);
		model.addAttribute("plant",plants);
		return "plant/card";
	}
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		Plant plants = srvPlant.findById(id);
		model.addAttribute("plant", plants);
		model.addAttribute("title","Actualización de registro");
		return "plant/form";
	}
	
	@GetMapping(value="/delete/{id}")
	public String delete(@PathVariable(value="id") Integer id, Model model, RedirectAttributes flash) {
		try {
			srvPlant.delete(id);
			flash.addFlashAttribute("success","El registro fue eliminado");
		} catch (Exception e) {
			flash.addFlashAttribute("error","El registro no puede ser eliminado");
		}
		
		return "redirect:/plant/list";
	}
	
	@PostMapping(value="/save") 
	public String save(@Validated Plant plant, BindingResult result, Model model,
			@RequestParam("photo_plant") MultipartFile image,
			SessionStatus status, RedirectAttributes flash) {
		try {
			
			String message = "Planta agregado correctamente";
			String titulo = "Nuevo registro de Planta";
			
			if(plant.getIdplant() != null) {
				message = "Planta actualizada correctamente";
				titulo = "Actualizando el registro de " + plant;
			}
						
			if(result.hasErrors()) {
				model.addAttribute("title", titulo);							
				return "plant/form";				
			}
			
			if (!image.isEmpty()) {				
				Path dir = Paths.get("src//main//resources//static//photos_plants");
				String rootPath = dir.toFile().getAbsolutePath();
				try {
					byte[] bytes = image.getBytes();
					Path rutaCompleta = Paths.get(rootPath + "//" + image.getOriginalFilename());
					Files.write(rutaCompleta, bytes);
					plant.setImage_plant(image.getOriginalFilename());

				} catch (IOException e) {
					e.printStackTrace();
				}
			}													
			srvPlant.save(plant);	
			status.setComplete();
			flash.addFlashAttribute("success", message);
		}
		catch(Exception ex) {
			flash.addFlashAttribute("error", ex.getMessage());
		}				
		return "redirect:/plant/list";
	}
	
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<Plant> plants = srvPlant.findAll();
		model.addAttribute("plants", plants);
		model.addAttribute("title", "Listado de plantas");
		return "plant/list";
	}
}
