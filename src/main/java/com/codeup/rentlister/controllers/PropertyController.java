package com.codeup.rentlister.controllers;
import com.codeup.rentlister.models.*;
import com.codeup.rentlister.repositories.*;
import com.codeup.rentlister.services.EmailService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import com.codeup.rentlister.services.PropertyService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import java.lang.String;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class PropertyController {

	private final EmailService emailService;
	private final PropertyRepository propertyDao;
	private final UserRepository userDao;
	private final PropertyService propertyService;
	private final InquiriesRepository inquiryDao;
	private final WorkOrderRepository workOrderDao;
	private final ReviewRepository reviewDao;

	@Value("${mapBoxKey}")
	private String mapBoxKey;

	public PropertyController(EmailService emailService, PropertyRepository propertyDao, UserRepository userDao, PropertyService propertyService, InquiriesRepository inquiryDao, WorkOrderRepository workOrderDao, ReviewRepository reviewDao) {
		this.emailService = emailService;
		this.propertyDao = propertyDao;
		this.userDao = userDao;
		this.propertyService = propertyService;
		this.inquiryDao = inquiryDao;
		this.workOrderDao = workOrderDao;
		this.reviewDao = reviewDao;
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

		property.setManager(user);

		property.setLatitude(BigDecimal.valueOf(30.267250));
		property.setLongitude(BigDecimal.valueOf(-97.743150));

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

	@GetMapping("/property/{id}/edit")
	public String propertyEdit(@PathVariable int id, Model model) {
		Property property = propertyDao.findPropertyById(id);
		model.addAttribute("property", property);
		return "property/edit";
	}

	@PostMapping("/property/{id}/edit")
	public String updateProperty(
			@PathVariable int id,
			@ModelAttribute Property newProperty){
		Property property = propertyDao.findPropertyById(id);

		property.setType(newProperty.getType());
		property.setRent(newProperty.getRent());
		property.setArea(newProperty.getArea());
		property.setType(newProperty.getType());
		property.setBeds(newProperty.getBeds());
		property.setBath(newProperty.getBath());
		property.setAddress(newProperty.getAddress());
		property.setCity(newProperty.getCity());
		property.setState(newProperty.getState());
		property.setZip(newProperty.getZip());
		property.setPets(newProperty.isPets());
		property.setDescription(newProperty.getDescription());
		property.setLatitude(newProperty.getLatitude());
		property.setLongitude(newProperty.getLongitude());

		propertyDao.save(property);

		return "redirect:/property/" + id;
	}

	@GetMapping("/property/{id}")
	public String propertyView(@PathVariable int id, Model model) {
		Property property = propertyDao.findPropertyById(id);

		List<Inquiries> inquiries = inquiryDao.findInquiriesByPropertyId(id);
		List<WorkOrder> workOrders = workOrderDao.findWorkOrderByPropertyId(id);
		List<Review> reviews = reviewDao.findReviewsByPropertyId(id);

		model.addAttribute("property", property);
		model.addAttribute("inquiries", inquiries);
		model.addAttribute("workOrders", workOrders);
		model.addAttribute("reviews", reviews);
		model.addAttribute("mapBoxKey", mapBoxKey);

		return "property/show";
	}

}