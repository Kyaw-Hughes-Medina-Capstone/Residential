package com.codeup.rentlister.controllers;

import com.codeup.rentlister.models.Property;
import com.codeup.rentlister.models.Review;
import com.codeup.rentlister.models.User;
import com.codeup.rentlister.repositories.PropertyRepository;
import com.codeup.rentlister.repositories.ReviewRepository;
import com.codeup.rentlister.repositories.UserRepository;
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
	public String createReview(
			@PathVariable int id,
			@RequestParam(name = "rating") int rating,
			@RequestParam(name = "description") String description){

		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int userId = user.getId();//tenant by current user -> tenant_id
		User tenant = userDao.findUserById(userId); //USER NEEDS TO BE LOGGED IN TO SUBMIT REVIEW

		Property property = propertyDao.findPropertyById(id);
		Review review = new Review(tenant, property, rating, description);
		reviewDao.save(review);

//		emailService.sendAReviewEmail(review, "You have a review on a property!", "Check your account for more information.");

		return "redirect:/property/" + id;
	}

}