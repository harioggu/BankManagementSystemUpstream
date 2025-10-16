package com.service;

import com.model.Admin;

public interface AdminService {
	public Admin findById(int id);
	public String findByUsername(String username);
	public String addCustomer(String name, String dob, String email, String mobile, String address, String status, String accountType);
}
