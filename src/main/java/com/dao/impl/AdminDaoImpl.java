package com.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.AdminDao;
import com.model.Admin;
import com.model.Customer;

import jakarta.transaction.Transactional;

@Repository
public class AdminDaoImpl implements AdminDao{
	@Autowired
	private SessionFactory sessionFactory;
	public Admin getAdminById(int id) {
		return sessionFactory.getCurrentSession().get(Admin.class, id);
	}
	@Override
	public Admin getAdminByUsername(String username) {
		Admin admin = sessionFactory.getCurrentSession().createQuery("From Admin Where username=:username", Admin.class)
											.setParameter("username", username).uniqueResult();
		return admin;
	}
	@Override
	public void saveCustomer(Customer customer) {
		sessionFactory.getCurrentSession().save(customer);
	}
}
