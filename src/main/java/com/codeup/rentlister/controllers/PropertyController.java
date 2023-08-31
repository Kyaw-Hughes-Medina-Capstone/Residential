package com.codeup.rentlister.controllers;

import com.codeup.rentlister.models.*;
import com.codeup.rentlister.repositories.*;
import com.codeup.rentlister.services.EmailService;
import com.codeup.rentlister.services.PropertyService;
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
			@RequestParam(name = "type") String type,
			@RequestParam(name = "rent") int rent,
			@RequestParam(name = "area") int area,
			@RequestParam(name = "beds") int beds,
			@RequestParam(name = "bath") int bath,
			@RequestParam(name = "address") String address,
			@RequestParam(name = "city") String city,
			@RequestParam(name = "state") String state,
			@RequestParam(name = "zip") int zip,
			@RequestParam(name = "pets") String pets,
			@RequestParam(name = "description") String description){

		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int userId = user.getId();
		User manager = userDao.findUserById(userId);

		Property property = new Property(manager, type, rent, area, beds, bath, address, city, state, zip, pets, description);

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
		List<Review> reviews = reviewDao.findReviewsByPropertyId(id);
		List<Inquiries> inquiries = inquiryDao.findInquiriesByPropertyId(id);
		model.addAttribute("property", property);
		model.addAttribute("reviews", reviews);
		model.addAttribute("inquiries", inquiries);
		return "property/show";
	}

	@GetMapping("/property/{id}/edit")
	public String editProperty(@PathVariable int id, Model model) {
		Property property = propertyDao.findPropertyById(id);
		model.addAttribute("property", property);
		return "property/edit";
	}

	@PostMapping("/property/{id}/edit")
	public String editProperty(@PathVariable int id, @ModelAttribute Property property) {
		Property propertyToUpdate = propertyDao.findPropertyById(id);
		propertyToUpdate.setRent(property.getRent());
		propertyToUpdate.setType(property.getType());
		propertyToUpdate.setBeds(property.getBeds());
		propertyToUpdate.setBath(property.getBath());
		propertyToUpdate.setPets(property.getPets());
		propertyToUpdate.setAddress(property.getAddress());
		propertyToUpdate.setCity(property.getCity());
		propertyToUpdate.setState(property.getState());
		propertyToUpdate.setZip(propertyToUpdate.getZip());
		propertyToUpdate.setLatitude(property.getLatitude());
		propertyToUpdate.setLongitude(property.getLongitude());
		propertyDao.save(propertyToUpdate);
		return "redirect:/property/" + id;
	}
}