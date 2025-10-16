package com.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Admin;
import com.model.Customer;


public interface AdminDao {
	public Admin getAdminById(int id);
	public Admin getAdminByUsername(String username);
	public void saveCustomer(Customer customer);
}
