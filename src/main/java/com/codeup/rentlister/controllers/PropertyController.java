package com.codeup.rentlister.controllers;
import com.codeup.rentlister.models.Property;
import com.codeup.rentlister.repositories.PropertyRepository;
import com.codeup.rentlister.repositories.UserRepository;
import com.codeup.rentlister.services.EmailService;
import org.apache.catalina.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import com.codeup.rentlister.services.PropertyService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import java.lang.String;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PropertyController {

	private final EmailService emailService;
	private final PropertyRepository propertyDao;
	private final UserRepository userDao;
	private final PropertyService propertyService;

	@Value("${mapBoxKey}")
	private String mapBoxKey;

	public PropertyController(EmailService emailService, PropertyRepository propertyDao, UserRepository userDao, PropertyService propertyService) {
		this.emailService = emailService;
		this.propertyDao = propertyDao;
		this.userDao = userDao;
		this.propertyService = propertyService;
	}


	//Home Page
	@GetMapping("/home")
	public String landing(Model model){
		model.addAttribute("property", propertyDao.findAll());
		return "home";
	}

	@GetMapping("/about")
	public String about(){
		return "about";
	}


	@GetMapping("/property")
	public String index(Model model){
		model.addAttribute("property", propertyDao.findAll());
		model.addAttribute("mapBoxKey", mapBoxKey);
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
		propertyDao.save(property);

		emailService.sendAPropertyEmail(property, "Here's your property", "Property body");
		return "redirect:/property";
	}
	@GetMapping("/filtered-properties")
	public String showFilteredPropertiesPage(Model model) {
		model.addAttribute("mapBoxKey", mapBoxKey);
		return "filtered-properties";
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
		model.addAttribute("mapBoxKey", mapBoxKey);
		return "property/filter";
	}

	@GetMapping("/contact")
	public String contact(){
		return"/contact";
	}

	@GetMapping("/property/{id}")
	public String propertyView(@PathVariable int id, Model model) {
		Property property = propertyDao.findPropertyById(id);
		model.addAttribute("property", property);
		model.addAttribute("mapBoxKey", mapBoxKey);
		return "property/show";
	}
}