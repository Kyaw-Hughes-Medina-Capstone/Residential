package com.codeup.rentlister.controllers;
import com.codeup.rentlister.models.Property;
import com.codeup.rentlister.repositories.PropertyRepository;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PropertyController {

//	private EmailService emailService;

	private final PropertyRepository propertyDao;

	public PropertyController(PropertyRepository propertyDao) {
		this.propertyDao = propertyDao;
	}

//	private final UserRepository userDao;



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