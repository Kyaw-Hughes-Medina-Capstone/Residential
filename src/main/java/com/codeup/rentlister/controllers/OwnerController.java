package com.codeup.rentlister.controllers;


import com.codeup.rentlister.models.Property;
import com.codeup.rentlister.repositories.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OwnerController {
    @Autowired
    private PropertyRepository propertyRepository;

    @GetMapping("/owner-portfolio")
    public String ownerPortfolio(Model model) {
        Iterable<Property> properties = propertyRepository.findAll();
        model.addAttribute("properties", properties);
        return "owner-portfolio";
    }
}



