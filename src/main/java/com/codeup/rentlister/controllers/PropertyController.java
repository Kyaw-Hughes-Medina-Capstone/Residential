package com.codeup.rentlister.controllers;

import com.codeup.rentlister.models.*;
import com.codeup.rentlister.repositories.*;
import com.codeup.rentlister.services.EmailService;
import com.codeup.rentlister.services.PropertyService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Properties;

@Controller
public class PropertyController {

	private EmailService emailService;
	private PropertyService propertyService;
	private PropertyRepository propertyDao;
	private ReviewRepository reviewDao;
	private InquiriesRepository inquiryDao;
	private final UserRepository userDao;

	public PropertyController(EmailService emailService, PropertyService propertyService, PropertyRepository propertyDao, UserRepository userDao, ReviewRepository reviewDao, InquiriesRepository inquiryDao) {
		this.emailService = emailService;
		this.propertyService = propertyService;
		this.propertyDao = propertyDao;
		this.userDao = userDao;
		this.reviewDao = reviewDao;
		this.inquiryDao = inquiryDao;
	}
	@Value("${mapBoxKey}")
	private String mapBoxKey;
	@Value("${fileStackKey}")
	private String fileStackKey;


	@GetMapping("/property")
	public String index(Model model) {
		model.addAttribute("property", propertyDao.findAll());
		model.addAttribute("mapBoxKey", mapBoxKey);
		model.addAttribute("fileStackKey", fileStackKey);
		return "property/index";
	}

	@GetMapping("/property/create")
	public String createProperty(Model model) {
		model.addAttribute("property", new Property());
		model.addAttribute("fileStackKey", fileStackKey);
		return "property/create";
	}
	@PostMapping("/property/create")
	public String createProperty(@ModelAttribute Property property) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int userId = user.getId();
		User manager = userDao.findUserById(userId);
		System.out.println(property);
		propertyDao.save(property);
		return "redirect:/property";
	}
	@GetMapping("/property/{id}")
	public String propertyDetail(@PathVariable long id, Model model) {
		model.addAttribute("property", propertyDao.findById((int) id).get());
		model.addAttribute("mapBoxKey", mapBoxKey);
		return "property/detail";
	}
	@GetMapping("/property/{id}/edit")
	public String propertyEdit(@PathVariable long id, Model model) {
		Property propertyToEdit = propertyDao.findById((int) id).get();
		model.addAttribute("property", propertyToEdit);
		return "property/edit";
	}
	@PostMapping("/property/{id}/edit")
	public String propertyEditPost(@PathVariable long id, @ModelAttribute Property newProperty){
		Property propertyToEdit = propertyDao.findPropertyById(id);
		propertyDao.save(propertyToEdit );
		return "redirect:/property";
	}


	@GetMapping("/filtered-properties")
	public String filterProperty(Model model) {
		model.addAttribute("mapBoxKey", mapBoxKey);
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
		model.addAttribute("mapBoxKey", mapBoxKey);
		return "/property/filter";
	}


	@GetMapping("/filtered-properties")
	public String showFilteredPropertiesPage(Model model) {
		return "/filtered-properties";
	}


	@GetMapping("/property/{id}")
	public String propertyView(@PathVariable int id, Model model) {
		Property property = propertyDao.findPropertyById(id);
		List<Review> reviews = reviewDao.findReviewsByPropertyId(id);
		List<Inquiries> inquiries = inquiryDao.findInquiriesByPropertyId(id);
		model.addAttribute("property", property);
		model.addAttribute("reviews", reviews);
		model.addAttribute("inquiries", inquiries);
		return "property/show";
	}

}