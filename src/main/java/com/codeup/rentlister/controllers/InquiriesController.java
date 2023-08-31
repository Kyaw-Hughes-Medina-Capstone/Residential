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
			@RequestParam(name = "start_date") String start_date,
			@RequestParam(name = "end_date") String end_date,
			@RequestParam(name = "people") int people,
			@RequestParam(name = "pets") String pets) {

		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int userId = user.getId();//tenant by current user -> tenant_id
		User tenant = userDao.findUserById(userId); //USER NEEDS TO BE LOGGED IN TO SUBMIT INQUIRY

		Property property = propertyDao.findPropertyById(id);

		User manager = property.getManager(); //get manager by user_id -> property -> manager_id

		Inquiries inquiry = new Inquiries(start_date, end_date, people, pets, property, tenant, manager);
		inquiry.setStart_date(start_date);
		inquiry.setEnd_date(end_date);

		inquiriesDao.save(inquiry);

		emailService.sendAnInquiryEmail(inquiry, "You have an inquiry about a property!", "Check your account for more information.");

		return "redirect:/property/" + id;
	}
}