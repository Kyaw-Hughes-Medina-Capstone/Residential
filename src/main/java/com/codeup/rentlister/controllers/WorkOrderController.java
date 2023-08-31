package com.codeup.rentlister.controllers;
import com.codeup.rentlister.models.Property;
import com.codeup.rentlister.models.User;
//import com.codeup.rentlister.models.UserWithRoles;
import com.codeup.rentlister.models.WorkOrder;
import com.codeup.rentlister.repositories.PropertyRepository;
import com.codeup.rentlister.repositories.UserRepository;
import com.codeup.rentlister.repositories.WorkOrderRepository;
import com.codeup.rentlister.services.EmailService;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.hibernate.jdbc.Work;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
			@RequestParam(name = "description") String description) {

		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int userId = user.getId();
		User tenant = userDao.findUserById(userId); //tenant by current user -> tenant_id

		//USER NEEDS TO BE LOGGED IN TO SUBMIT WORK ORDER
		Property property = propertyDao.findPropertyByTenantId(userId);

		User manager = property.getManager(); //get manager by user_id -> property -> manager_id

		String date = LocalDate.now().toString();

		WorkOrder workOrder = new WorkOrder(tenant, manager, property, description, date);

		workOrderDao.save(workOrder);

		emailService.sendAWorkOrderEmail(workOrder, "A work order has been submitted to one of your properties!", "Check your account for more information.");

		return "redirect:/property/workorder";
	}

}