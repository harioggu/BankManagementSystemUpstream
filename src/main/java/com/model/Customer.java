package com.model;

import jakarta.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {
	@Id
    @Column(name="account_number", nullable = false, unique = true, length = 20)
    private String accountNumber;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false, length = 15)
    private String mobile;

    private String dob;
    private String address;

    @Column(length = 255)
    private String password; // after reset (hashed)

    @Column(name="default_password", length = 255)
    private String defaultPassword; // system generated

    @Column(name="reset_required", nullable = false)
    private boolean resetRequired = true;

    @Column(length = 20)
    private String status = "ACTIVE";
    
    private String otp;
    
    @OneToOne(mappedBy="customer", cascade = CascadeType.ALL)
    private Account account;

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDefaultPassword() {
		return defaultPassword;
	}

	public void setDefaultPassword(String defaultPassword) {
		this.defaultPassword = defaultPassword;
	}

	public boolean isResetRequired() {
		return resetRequired;
	}

	public void setResetRequired(boolean resetRequired) {
		this.resetRequired = resetRequired;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
    
    
}
