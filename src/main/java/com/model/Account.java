package com.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="account")
public class Account {
	@Id
    @Column(name="account_number")
	private String accountNumber;
	@Column(name="balance")
    private double balance;
    @Column(name="account_type")
    private String accountType;
    @Column(name="branch")
    private String branch;

    // One-to-One mapping back to Customer
    @OneToOne
    @JoinColumn(name = "account_number", referencedColumnName = "account_number")
    private Customer customer;

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Account() {
		
	}
	public Account(String accountNumber, double balance, String accountType, String branch, Customer customer) {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.accountType = accountType;
		this.branch = branch;
		this.customer = customer;
	}
}
