package com.codeup.rentlister.controllers;
import com.codeup.rentlister.models.Property;
import com.codeup.rentlister.models.User;
import com.codeup.rentlister.models.UserWithRoles;
import com.codeup.rentlister.models.WorkOrder;
import com.codeup.rentlister.repositories.PropertyRepository;
import com.codeup.rentlister.repositories.UserRepository;
import com.codeup.rentlister.repositories.WorkOrderRepository;
import com.codeup.rentlister.services.EmailService;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;

@Controller
public class WorkOrderController {

	private EmailService emailService;

	private final WorkOrderRepository workOrderDao;

	private final PropertyRepository propertyDao;

	private final UserRepository userDao;

	public WorkOrderController(WorkOrderRepository workOrderDao, PropertyRepository propertyDao, UserRepository userDao, EmailService emailService){
		this.workOrderDao = workOrderDao;
		this.propertyDao = propertyDao;
		this.userDao = userDao;
		this.emailService = emailService;
	}

	@GetMapping("/property/workorder")
	public String WorkOrder(Model model){
		model.addAttribute("workorder", workOrderDao);
		return "property/workorder";
	}

	@PostMapping("/property/workorder")
	public String createWorkOrder(
			@RequestParam(name = "property_id") int propertyId,
			@RequestParam(name = "description") String description,
			@RequestParam(name = "date") Date date) {

		User tenant = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Property property = propertyDao.findPropertyById(propertyId); // Get property from repository based on property_id
		User manager = property.getManager(); // Get manager from property

		WorkOrder workOrder = new WorkOrder(tenant, manager, property, description, date);
		System.out.println(workOrder.toString());

		emailService.sendAWorkOrderEmail(workOrder, "A tenant submitted a work order", "Check your account for more information");
		return "redirect:/property/workorder";
	}


}