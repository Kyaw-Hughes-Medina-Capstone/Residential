package com.codeup.rentlister.controllers;

import com.codeup.rentlister.models.*;
import com.codeup.rentlister.repositories.*;
import com.codeup.rentlister.services.EmailService;
import com.codeup.rentlister.services.PropertyService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ReviewController {


	private EmailService emailService;

	private final PropertyRepository propertyDao;
	private final ReviewRepository reviewDao;
	private final UserRepository userDao;

	public ReviewController(ReviewRepository reviewDao, PropertyRepository propertyDao, EmailService emailService, UserRepository userDao) {
		this.reviewDao = reviewDao;
		this.emailService = emailService;
		this.propertyDao = propertyDao;
		this.userDao = userDao;
	}

	@GetMapping("/property/{id}/review")
	public String showReviewForm(@PathVariable int id, Model model) {
		Property property = propertyDao.findPropertyById(id);
		model.addAttribute("review", new Review());
		return "property/review" ;
	}

	@PostMapping("/property/{id}/review")
	public String createReview(@PathVariable int id,
							   @RequestParam int rating,
							   @RequestParam String description) {

		User tenant = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Property property = propertyDao.findPropertyById(id);

		Review review = new Review(tenant, property, rating, description);
		reviewDao.save(review);

		return "redirect:/property/" + id;
	}

}