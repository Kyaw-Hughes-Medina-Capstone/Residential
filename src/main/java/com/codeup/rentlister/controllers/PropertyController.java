package com.codeup.rentlister.controllers;
import com.codeup.rentlister.models.Property;
import com.codeup.rentlister.repositories.PropertyRepository;

import com.codeup.rentlister.repositories.UserRepository;
import com.codeup.rentlister.services.EmailService;
import com.codeup.rentlister.services.PropertyService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PropertyController {

	private EmailService emailService;
	private PropertyService propertyService;
	private PropertyRepository propertyDao;
	private final UserRepository userDao;

	public PropertyController(EmailService emailService, PropertyService propertyService, PropertyRepository propertyDao, UserRepository userDao) {
		this.emailService = emailService;
		this.propertyService = propertyService;
		this.propertyDao = propertyDao;
		this.userDao = userDao;
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
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println(property);
		propertyDao.save(property);

		return "redirect:/property";
	}

	@GetMapping("/filtered-properties")
	public String showFilteredPropertiesPage(Model model) {
		return "/filtered-properties";
	}

	@PostMapping("/filtered-properties")
	public String filterProperties(
			@RequestParam(required = false, name = "type") String type,
			@RequestParam(required = false, name = "city") String city,
			@RequestParam(required = false, name = "minBedrooms") Integer minBedrooms,
			@RequestParam(required = false, name = "minBathrooms") Integer minBathrooms,
			@RequestParam(required = false, name = "maxPrice") Integer maxPrice,
			@RequestParam(required = false, name = "minPrice") Integer minPrice,
			Model model
	) {
		if (type != null && type.isEmpty()) {
			type = null;
		}
		if (city != null && city.isEmpty()) {
			city = null;
		}

		List<Property> filteredProperties = propertyService.filterProperties(type, city, minBedrooms, minBathrooms, maxPrice, minPrice);
		model.addAttribute("filteredProperty", filteredProperties);

		return "/property/filter";
	}

	@GetMapping("/property/{id}")
	public String propertyView(@PathVariable int id, Model model) {
		Property property = propertyDao.findPropertyById(id);
		model.addAttribute("property", property);
		return "property/show";
	}

	@GetMapping("/property/{id}/edit")
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
		return "redirect:/property/" + id;
	}
}