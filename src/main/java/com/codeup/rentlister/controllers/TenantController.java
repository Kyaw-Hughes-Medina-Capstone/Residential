package com.codeup.rentlister.controllers;

import com.codeup.rentlister.models.MoveInForm;
import com.codeup.rentlister.models.Property;
import org.springframework.stereotype.Controller;
import com.codeup.rentlister.repositories.MoveInRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TenantController {
    private final MoveInRepository moveInDao;

    public TenantController(MoveInRepository moveInDao) {
        this.moveInDao = moveInDao;
    }

    @GetMapping("/tenant/lease")
    public String leaseForm(){
        return "/tenant/lease";
    }
    @GetMapping("/tenant/move-in")
    public String moveInForm(Model model){
        model.addAttribute("move_in", new MoveInForm());
        return "/tenant/move-in";
    }
    @PostMapping("/tenant/move-in")
    public String createMoveIn(
            @ModelAttribute MoveInForm moveInForm) {
        moveInDao.save(moveInForm);
        return "/tenant/index";
    }
    @GetMapping("/tenant/faq")
    public String question(){
        return "/tenant/faq";
    }
    @GetMapping("/tenant/forms")
    public String forms(){
        return "/tenant/forms";
    }
    @GetMapping("/tenant/payment")
    public String payment(){
        return "/tenant/payment";
    }
}