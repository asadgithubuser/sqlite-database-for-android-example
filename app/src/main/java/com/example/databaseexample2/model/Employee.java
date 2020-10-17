package com.example.databaseexample2.model;

import java.io.Serializable;

public class Employee implements Serializable {

	public static final String TAG = "Employee";
	private static final long serialVersionUID = -7406082437623008161L;

	private long mId;
	private String mFirstName;
	private String mLastName;
	private String mAddress;
	private String mPhoneNumber;
	private String mEmail;
	private double mSalary;
	private Company mCompany;

	public Employee() {
		
	}

	public Employee(String firstName, String lastName, String address, String phoneNumber, String email, double salary) {
		this.mFirstName = firstName;
		this.mLastName = lastName;
		this.mAddress = address;
		this.mPhoneNumber = phoneNumber;
		this.mEmail = email;
		this.mSalary = salary;
	}

	public long getId() {
		return mId;
	}

	public void setId(long mId) {
		this.mId = mId;
	}

	public String getFirstName() {
		return mFirstName;
	}

	public void setFirstName(String mFirstName) {
		this.mFirstName = mFirstName;
	}

	public String getLastName() {
		return mLastName;
	}

	public void setLastName(String mLastName) {
		this.mLastName = mLastName;
	}

	public String getAddress() {
		return mAddress;
	}

	public void setAddress(String mAddress) {
		this.mAddress = mAddress;
	}

	public String getPhoneNumber() {
		return mPhoneNumber;
	}

	public void setPhoneNumber(String mPhoneNumber) {
		this.mPhoneNumber = mPhoneNumber;
	}

	public String getEmail() {
		return mEmail;
	}

	public void setEmail(String mEmail) {
		this.mEmail = mEmail;
	}

	public double getSalary() {
		return mSalary;
	}

	public void setSalary(double mSalary) {
		this.mSalary = mSalary;
	}

	public Company getCompany() {
		return mCompany;
	}

	public void setCompany(Company mCompany) {
		this.mCompany = mCompany;
	}
}
