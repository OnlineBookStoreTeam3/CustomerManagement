package com.bootcamp.customermanagement.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="customer")
@SequenceGenerator(name = "customer_id_gen",initialValue = 10000,allocationSize = 1)
public class Customer 
{
	
    @GeneratedValue(generator = "customer_id_gen",strategy = GenerationType.SEQUENCE)	
	@Column(name="customer_id")
	int customerId;
	@Column(name="fullname")
    String fullName;
	@Id
	@Column(name="emailaddress")
	String emailAddress;
	@Column(name="password")
	String password;
	@Column(name="phone_No")
	Long phoneNumber;
	@Column(name="address")
	String address;
	@Column(name="city")
	String city;
	@Column(name="country")
	String country;
	@Column(name="zipcode")
	Long zipCode;
	@Column(name="registered_date")
	LocalDate registerDate;
	public Customer()
	{
		
	}
	public Customer(int customerId, String fullName, String emailAddress, String password, Long phoneNumber,
			String address, String city, String country, Long zipCode, LocalDate registerDate) {
		super();
		this.customerId = customerId;
		this.fullName = fullName;
		this.emailAddress = emailAddress;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.city = city;
		this.country = country;
		this.zipCode = zipCode;
		this.registerDate = registerDate;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Long getZipCode() {
		return zipCode;
	}
	public void setZipCode(Long zipCode) {
		this.zipCode = zipCode;
	}
	public LocalDate getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(LocalDate registerDate) {
		this.registerDate = registerDate;
	}
	
	
	
}
