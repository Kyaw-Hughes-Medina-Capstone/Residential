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

//	@PostMapping("/property/create")
//	public String createProperty(
//			@RequestParam(name = "type") String type,
//			@RequestParam(name = "rent") float rent,
//			@RequestParam(name = "area") int area,
//			@RequestParam(name = "beds") int beds,
//			@RequestParam(name = "bath") int bath,
//			@RequestParam(name = "img1") String img1,
//			@RequestParam(name = "img2") String img2,
//			@RequestParam(name = "img3") String img3,
//			@RequestParam(name = "img4") String img4,
//			@RequestParam(name = "address") String address,
//			@RequestParam(name = "city") String city,
//			@RequestParam(name = "state") String state,
//			@RequestParam(name = "zip") int zip,
//			@RequestParam(name = "pets") String pets,
//			@RequestParam(name = "description") String description) {
////		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		Property property = new Property(type, rent, area, beds, bath, img1, img2, img3, img4, address, city, state, zip, pets, description);
//		System.out.println(property);
//		propertyDao.save(property);
//
////		emailService.sendAPropertyEmail(property, "Here's your property", "Property body");
//		return "redirect:/property";
//	}

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