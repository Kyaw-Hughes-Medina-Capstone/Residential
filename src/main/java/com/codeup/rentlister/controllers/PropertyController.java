package com.codeup.rentlister.controllers;
import com.codeup.rentlister.models.Property;
import com.codeup.rentlister.repositories.PropertyRepository;

import com.codeup.rentlister.services.PropertyService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PropertyController {

//	private EmailService emailService;
	private PropertyService propertyService;

	private final PropertyRepository propertyDao;

	public PropertyController(PropertyService propertyService, PropertyRepository propertyDao) {
		this.propertyService = propertyService;
		this.propertyDao = propertyDao;
	}

//Home Page
	@GetMapping("/home")
	public String landing(Model model){
		model.addAttribute("property", propertyDao.findAll());
		return "/home";
	}


	@GetMapping("/property")
	public String index(Model model){
		model.addAttribute("property", propertyDao.findAll());
		return "property/index";
	}

	@GetMapping("/property/create")
	public String showPropertyCreateForm(Model model) {
		model.addAttribute("property", new Property());
		return "property/create";
	}

	@PostMapping("/property/create")
	public String createProperty(
			@ModelAttribute Property property) {
//		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println(property);
		propertyDao.save(property);

//		emailService.sendAPropertyEmail(property, "Here's your property", "Property body");
		return "redirect:/property";
	}
	@GetMapping("/filtered-properties")
	public String showFilteredPropertiesPage(Model model) {

		return "/filtered-properties";
	}

	@PostMapping("/filtered-properties")
	public String filterProperties(
			@RequestParam(required = false) String type,
			@RequestParam(required = false) String city,
			@RequestParam(required = false) Integer zip,
			@RequestParam(required = false) Integer minBedrooms,
			@RequestParam(required = false) Integer minBathrooms,
			@RequestParam(required = false) Integer maxPrice,
			@RequestParam(required = false) Integer minPrice,
			Model model

	) {
		if(type != null && type.isEmpty()){
			type = null;
		}if(city != null && city.isEmpty()){
			city =null;
		}

		List<Property> filteredProperties = propertyService.filterProperties(type, city, zip, minBedrooms, minBathrooms, maxPrice, minPrice);
		model.addAttribute("filteredProperty", filteredProperties);

		return "/property/filter";
	}

	@GetMapping("/contact")
	public String contact(){
		return"/contact";
	}



	@GetMapping("/property/{id}")
	public String propertyView(@PathVariable int id, Model model) {
		Property property = propertyDao.findPropertyById(id);
		model.addAttribute("property", property);
		return "property/show";
	}

	@GetMapping("/ads/{id}/edit")
	public String editOneListing(@PathVariable int id, Model model) {
		Property property = propertyDao.findPropertyById(id);
		model.addAttribute("property", property);
		return "/property/edit";
	}

	@PostMapping("/property/{id}/edit")
	public String editProperty(@PathVariable int id, @ModelAttribute Property property) {
		Property propertyToUpdate = propertyDao.findPropertyById(id);
		propertyToUpdate.setBeds(property.getBeds());
		propertyToUpdate.setBath(property.getBath());
		propertyDao.save(propertyToUpdate);
		return "redirect:/ads/" + id;
	}
}