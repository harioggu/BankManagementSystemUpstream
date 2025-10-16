package com.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.CustomerDao;
import com.model.Admin;
import com.model.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao{
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public Customer getCustomerByAccountNumber(String accountNumber, String password) {
		// TODO Auto-generated method stub
		Customer customer = sessionFactory.getCurrentSession().createQuery("From Customer Where accountNumber=:accountNumber And defaultPassword=:defaultPassword", Customer.class)
				.setParameter("accountNumber", accountNumber).setParameter("defaultPassword",password).uniqueResult();
		return customer;
	}
	@Override
	public String getOldPassword(String oldPassword) {
		// TODO Auto-generated method stub
		String oldPass = (String) sessionFactory.getCurrentSession().createQuery("Select defaultPassword From Customer Where defaultPassword=:defaultPassword")
				.setParameter("defaultPassword", oldPassword).uniqueResult();
		System.out.print(oldPass+" "+oldPassword);
		return oldPass;
	}
	@Override
	public void saveNewPassword(String newPassword, String oldPassword) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().createQuery("Update Customer set password=:newPassword Where defaultPassword=:oldPassword")
		.setParameter("newPassword", newPassword).setParameter("oldPassword", oldPassword).executeUpdate();
		sessionFactory.getCurrentSession().createQuery("Update Customer set resetRequired=:resetRequired Where defaultPassword=:oldPassword")
		.setParameter("resetRequired", false).setParameter("oldPassword", oldPassword).executeUpdate();
	}
	@Override
	public boolean getResetRequired(String accountNumber) {
		// TODO Auto-generated method stub
		boolean resetReq = (boolean)sessionFactory.getCurrentSession().createQuery("Select resetRequired From Customer Where accountNumber=:accountNumber")
				.setParameter("accountNumber", accountNumber).uniqueResult();
		return resetReq;
	}
	@Override
	public Customer getCustomerToRedirect(String accountNumber, String password) {
		// TODO Auto-generated method stub
		Customer customer = sessionFactory.getCurrentSession().createQuery("From Customer Where accountNumber=:accountNumber And password=:password", Customer.class)
				.setParameter("accountNumber", accountNumber).setParameter("password",password).uniqueResult();
		return customer;
	}
	@Override
	public String getEmailByAccountNumber(String accountNumber) {
		// TODO Auto-generated method stub
		String email = (String) sessionFactory.getCurrentSession().createQuery("Select email From Customer Where accountNumber=:accountNumber")
				.setParameter("accountNumber", accountNumber).uniqueResult();
		return email;
	}
	@Override
	public void saveOtp(String verifyOtp, String accountNumber) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().createQuery("Update Customer set otp=:verifyOtp Where accountNumber=:accountNumber")
		.setParameter("verifyOtp", verifyOtp).setParameter("accountNumber", accountNumber).executeUpdate();
	}
	@Override
	public String validateOtp(String otp) {
		// TODO Auto-generated method stub
		String savedOtp = (String)sessionFactory.getCurrentSession().createQuery("Select otp From Customer Where otp=:otp")
		.setParameter("otp", otp).uniqueResult();
		return "savedOtp";
	}
	@Override
	public double viewBalance(String accountNumber) {
		// TODO Auto-generated method stub
		double balance = (double)sessionFactory.getCurrentSession().createQuery("Select balance From Account Where accountNumber=:accountNumber")
				.setParameter("accountNumber", accountNumber).uniqueResult();
		return balance;
	}
}
