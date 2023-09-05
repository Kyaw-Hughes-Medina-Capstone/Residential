package com.codeup.rentlister.controllers;


import com.codeup.rentlister.models.Property;
import com.codeup.rentlister.repositories.PropertyRepository;
import com.codeup.rentlister.services.EmailService;
import org.antlr.v4.runtime.misc.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;


@Controller
public class OwnerController {
    @Autowired
    private PropertyRepository ownerRepository;
    private LogManager propertyDao;

    @GetMapping("/owner/portfolio")
    public String ownerPortfolio(Model model) {
        Iterable<Property> properties = ownerRepository.findAll();
        model.addAttribute("ownerProperties", properties);
        return "owner/portfolio";
    }

    @PostMapping("owner/portfolio")
    public String ownerProperty(
            @ModelAttribute Property property, EmailService emailService) throws IOException {
        com.codeup.rentlister.models.User user = (com.codeup.rentlister.models.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(property);
        propertyDao.save(String.valueOf(property));

        emailService.sendAPropertyEmail(property, "Here's your property", "Property body");
        return "redirect:/property";
    }
}




