package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.Admin;
import com.service.AdminService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	AdminService adminService;
	
	@GetMapping("/AdminLoginIn")
	public String loginIn() {
		return "adminLogin";
	}
	
	@PostMapping("/AdminLogin")
	public String login(@RequestParam("username") String username,
            @RequestParam("password") String password) {
		return adminService.findByUsername(username);
	}
	
	@GetMapping("/CreateAccount")
	public String createAccount() {
		return "createCustomerAccount";
	}
	
	@PostMapping("/CreateCustomer")
	public String createCustomer(@RequestParam("name") String name,
			@RequestParam("dob") String dob,
			@RequestParam("email") String email,
			@RequestParam("mobile") String mobile,
			@RequestParam("address") String address,
			@RequestParam("status") String status,
			@RequestParam("accountType") String accountType) {
		
		return adminService.addCustomer(name, dob, email, mobile, address, status, accountType);
	}
}
