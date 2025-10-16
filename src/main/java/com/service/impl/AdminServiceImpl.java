package com.service.impl;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.dao.AdminDao;
import com.model.Account;
import com.model.Admin;
import com.model.Customer;
import com.service.AdminService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService{
	@Autowired
	private AdminDao adminDao;
	
	@Autowired
    private JavaMailSender mailSender;

	@Override
	public Admin findById(int id) {
		// TODO Auto-generated method stub
		return adminDao.getAdminById(id);
	}

	@Override
	public String findByUsername(String username) {
		Admin admin = adminDao.getAdminByUsername(username);
		if(admin!=null) {
			return "AdminDashboard";
		}
		else {
			return "adminLogin";
		}
	}

	@Override
	public String addCustomer(String name, String dob, String email, String mobile, String address, String status, String accountType) {
		// TODO Auto-generated method stub
		Customer customer = new Customer();
		customer.setName(name);
		customer.setDob(dob);
		customer.setEmail(email);
		customer.setMobile(mobile);
		customer.setAddress(address);
		customer.setStatus(status);
		Random random = new Random();
        String accountNumber = String.valueOf(1000000000L + (long)(random.nextDouble() * 9000000000L));
        customer.setAccountNumber(accountNumber);
        String defaultPassword = "PWD" + (100000 + random.nextInt(900000)); // Example: PWD456789
        customer.setDefaultPassword(defaultPassword);
        customer.setPassword(null);
        adminDao.saveCustomer(customer);
        
        Account account = new Account();
        account.setAccountNumber(accountNumber);
        account.setAccountType(accountType);
        account.setBalance(0);
        account.setBranch("Vijayawada");
        account.setCustomer(customer);
        customer.setAccount(account);
        
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Account Confirmation!");
        message.setText("Hi "+name+",\nYour Bank Account has been created successfully!\nPlease find the details:\n"+"Account Number: "+accountNumber+"\nDefault Password: "+defaultPassword+"\nYou can now login and reset password!!!");
        message.setFrom("harioggupersonal12@gmail.com");
        mailSender.send(message);
        
		return "AdminDashboard";
	}
	

}
