package com.service;

public interface CustomerService {
	public String findByAccountNumber(String accountNumber, String password);
	public String doResetPassword(String oldPassword, String newPassword, String confirmPassword);
	public String validateOtp(String otp);
	public double viewBalance(String accountNumber);
}
