package com.codeup.rentlister.controllers;
import com.codeup.rentlister.models.*;
import com.codeup.rentlister.repositories.*;
import com.codeup.rentlister.services.EmailService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class InquiriesController {

	private final InquiriesRepository inquiriesDao;
	private final PropertyRepository propertyDao;
	private final UserRepository userDao;
	private EmailService emailService;

	private User getCurrentUser() {
		return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}

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
			@RequestParam String start_date,
			@RequestParam String end_date,
			@RequestParam int people,
			@RequestParam String pets) {

		User user = getCurrentUser();
		User tenant = userDao.findUserById(user.getId());

		Property property = propertyDao.findPropertyById(id);
		User manager = property.getManager();

		Inquiries inquiry = new Inquiries(tenant, manager, property, start_date, end_date, people, pets);
		inquiriesDao.save(inquiry);

		emailService.sendAnInquiryEmail(inquiry, "You have an inquiry about a property!", "Check your account for more information.");

		return "redirect:/property/" + id;
	}

}