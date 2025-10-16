package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.service.CustomerService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	@GetMapping("/CustomerLoginIn")
	public String loginIn() {
		return "customerLogin";
	}
	@PostMapping("/CustomerLogin")
	public String login(@RequestParam("accountNumber") String accountNumber,
            @RequestParam("password") String password,
            HttpSession session) {
		session.setAttribute("accountNumber", accountNumber);
		return customerService.findByAccountNumber(accountNumber, password);
	}
	@PostMapping("/resettingpassword")
	public String resetPassword(@RequestParam("oldpassword") String oldPassword, 
			@RequestParam("newpassword") String newPassword,
			@RequestParam("confirmpassword") String confirmPassword) {
		return customerService.doResetPassword(oldPassword, newPassword, confirmPassword);
	}
	@PostMapping("/CustomerOtpValidate")
	public String otpValidation(@RequestParam("otp") String otp) {
		return customerService.validateOtp(otp);
	}
	@GetMapping("/viewBalance")
	public String viewBalance(HttpSession session, Model model) {
		String accountNumber = (String)session.getAttribute("accountNumber");
		double balance = customerService.viewBalance(accountNumber);
		model.addAttribute("balance",balance);
		return "viewBalance";
	}
	@GetMapping("/customerDashboard")
	public String customerDashboard() {
		return "customerDashboard";
	}
}
