package com.codeup.rentlister.controllers;
import com.codeup.rentlister.models.Property;
import com.codeup.rentlister.models.User;
import com.codeup.rentlister.models.UserWithRoles;
import com.codeup.rentlister.repositories.PropertyRepository;
import com.codeup.rentlister.repositories.UserRepository;
import com.codeup.rentlister.services.EmailService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@Controller
public class PropertyController {

	private EmailService emailService;

	private final PropertyRepository propertyDao;

	private final UserRepository userDao;

	public PropertyController(PropertyRepository propertyDao, UserRepository userDao, EmailService emailService){
		this.emailService = emailService;
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
			@RequestParam(name = "type") String type,
			@RequestParam(name = "rent") int rent,
			@RequestParam(name = "zip") int zip,
			@RequestParam(name = "address") String address,
			@RequestParam(name = "city") String city,
			@RequestParam(name = "state") String state,
			@RequestParam(name = "beds") int beds,
			@RequestParam(name = "bath") int bath,
			@RequestParam(name = "pets") String pets,
			@RequestParam(name = "yr") int year,
			@RequestParam(name = "latitude") BigDecimal latitude,
			@RequestParam(name = "longitude") BigDecimal longitude) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Property property = new Property(type, rent, zip, address, city, state, beds, bath, pets, year, latitude, longitude);
		propertyDao.save(property);

		emailService.sendAPropertyEmail(property, "Here's your property", "Property body");
		return "redirect:/property";
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
		return "redirect:/ads/" + id;
	}
}