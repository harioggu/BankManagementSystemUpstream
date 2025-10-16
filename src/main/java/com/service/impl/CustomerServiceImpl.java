package com.service.impl;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.dao.AdminDao;
import com.dao.CustomerDao;
import com.model.Admin;
import com.model.Customer;
import com.service.CustomerService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	private CustomerDao customerDao;
	@Autowired
	private JavaMailSender mailSender;
	@Override
	public String findByAccountNumber(String accountNumber, String password) {
		// TODO Auto-generated method stub
		boolean resetRequired = customerDao.getResetRequired(accountNumber);
		if(resetRequired) {
			Customer customer = customerDao.getCustomerByAccountNumber(accountNumber, password);
			if(customer!=null) {
				return "resetPassword";
			}
			else {
				return "customerLogin";
			}
		}
		else {
			Customer customer = customerDao.getCustomerToRedirect(accountNumber, password);
			if(customer!=null) {
				String email = customerDao.getEmailByAccountNumber(accountNumber);
				SimpleMailMessage message = new SimpleMailMessage();
				message.setTo(email);
				message.setSubject("Verify your account!");
				Random random = new Random();
				int otp = random.nextInt(90000)+1000;
				String verifyOtp = String.valueOf(otp);
				customerDao.saveOtp(verifyOtp, accountNumber);
				message.setText("Dear Customer,\nPlease find the otp below:\n OTP: "+verifyOtp+".\nPlease Enter the same in the portal.");
				message.setFrom("harioggupersonal12@gmail.com");
				mailSender.send(message);
				return "otp";
			}
			else {
				return "customerLogin";
			}
		}
		
		
	}

	@Override
	public String doResetPassword(String oldPassword, String newPassword, String confirmPassword) {
		// TODO Auto-generated method stub
		if(!(newPassword.equals(confirmPassword))) {
			return "resetPassword";
		}
		String oldPass = customerDao.getOldPassword(oldPassword);
		if(oldPass == null) {
			return "resetPassword";
		}
		customerDao.saveNewPassword(newPassword, oldPassword);
		return "customerLogin";
	}

	@Override
	public String validateOtp(String otp) {
		// TODO Auto-generated method stub
		String savedOtp = customerDao.validateOtp(otp);
		if(savedOtp==null) {
			return "otp";
		}
		else {
			return "customerDashboard";
		}
	}

	@Override
	public double viewBalance(String accountNumber) {
		// TODO Auto-generated method stub
		double balance = customerDao.viewBalance(accountNumber);
		return balance;
	}
}
