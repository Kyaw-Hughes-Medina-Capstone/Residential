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
			@RequestParam(name = "start_date") int start_date,
			@RequestParam(name = "end_date") int end_date,
			@RequestParam(name = "people") int people,
			@RequestParam(name = "pets") int pets,
			@RequestParam(name = "property") Property property,
			@RequestParam(name = "tenant") User tenant, //can be taken from user logged in? WIP
			@RequestParam(name = "manager") User manager) { //manager populated from property.manager_id? WIP
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Inquiries inquiries = new Inquiries(start_date, end_date, people, pets, property, tenant, manager);
		inquiriesDao.save(inquiries);

		emailService.sendAnInquiryEmail(inquiries, "You have an inquiry about a property!", "Check your account for more information.");
		return "redirect:/property/inquiry";

	}
}