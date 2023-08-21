package com.codeup.rentlister.controllers;
import com.codeup.rentlister.models.Inquiries;
import com.codeup.rentlister.models.Property;
import com.codeup.rentlister.models.User;
import com.codeup.rentlister.repositories.InquiriesRepository;
import com.codeup.rentlister.repositories.PropertyRepository;
import com.codeup.rentlister.repositories.UserRepository;
import com.codeup.rentlister.services.EmailService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;

@Controller
public class InquiriesController {

	private final InquiriesRepository inquiriesDao;

	private final PropertyRepository propertyDao;

	private final UserRepository userDao;

	private EmailService emailService;

	public InquiriesController(InquiriesRepository inquiriesDao, PropertyRepository propertyDao, UserRepository userDao, EmailService emailService){
		this.inquiriesDao = inquiriesDao;
		this.propertyDao = propertyDao;
		this.userDao = userDao;
		this.emailService = emailService;
	}

	@GetMapping("/property/{id}/inquiry")
	public String showInquiryCreateForm(@PathVariable int id, Model model) {
		Property property = propertyDao.findPropertyById(id);
		model.addAttribute("inquiries", new Inquiries());
		return "property/inquiry";
	}

	@PostMapping("/property/{id}/inquiry")
	public String createInquiry(
			@PathVariable int id,
			@RequestParam(name = "start_date") Date start_date,
			@RequestParam(name = "end_date") Date end_date,
			@RequestParam(name = "people") int people,
			@RequestParam(name = "pets") int pets) {

		User tenant = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Property property = propertyDao.findPropertyById(id); // Get property from repository based on id
		User manager = property.getManager(); // Get manager from property

		Inquiries inquiries = new Inquiries(tenant, manager, property, start_date, end_date, people, pets);
		inquiriesDao.save(inquiries);

		emailService.sendAnInquiryEmail(inquiries, "You have an inquiry about a property!", "Check your account for more information.");
		return "redirect:/property/inquiry";
	}

}