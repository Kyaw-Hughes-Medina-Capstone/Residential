package com.codeup.rentlister.controllers;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class TenantController {
    @GetMapping("/tenant/lease")
    public String leaseForm(){
        return "/tenant/lease";
    }
}
