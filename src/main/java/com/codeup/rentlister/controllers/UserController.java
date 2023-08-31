package com.codeup.rentlister.controllers;
import com.codeup.rentlister.models.User;
import com.codeup.rentlister.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
	private final UserRepository userDao;
	private final PasswordEncoder passwordEncoder;

	public UserController(UserRepository userDao, PasswordEncoder passwordEncoder) {
		this.userDao = userDao;
		this.passwordEncoder = passwordEncoder;
	}

	@GetMapping("/sign-up")
	public String showSignupForm(Model model){
		model.addAttribute("user", new User());
		return "users/sign-up";
	}

	@PostMapping("/sign-up")
	public String saveUser(@ModelAttribute User User){
		String hash = passwordEncoder.encode(User.getPassword());
		User.setPassword(hash.toString());
		userDao.save(User);
		return "redirect:/property";
	}

	@GetMapping("/contact")
	public String showContact(){
		return "users/contact";
	}
}