package com.dao;

import org.springframework.stereotype.Repository;

import com.model.Admin;
import com.model.Customer;


public interface CustomerDao {
	public Customer getCustomerByAccountNumber(String accountNumber, String password);
	public String getOldPassword(String oldPassword);
	public void saveNewPassword(String newPassword, String oldPassword);
	public boolean getResetRequired(String accountNumber);
	public Customer getCustomerToRedirect(String accountNumber, String password);
	public String getEmailByAccountNumber(String accountNumber);
	public void saveOtp(String verifyOtp, String accountNumner);
	public String validateOtp(String otp);
	public double viewBalance(String accountNumber);
}
