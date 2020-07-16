package com.bootcamp.customermanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bootcamp.customermanagement.dao.CustomerDao;
import com.bootcamp.customermanagement.dao.OrderDao;
import com.bootcamp.customermanagement.dao.ReviewDao;
import com.bootcamp.customermanagement.entity.Customer;
import com.bootcamp.customermanagement.entity.Order;
import com.bootcamp.customermanagement.entity.Review;

@Service
public class CustomerService 
{
	@Autowired
    CustomerDao cDao;
	OrderDao oDao;
	ReviewDao rDao;
	public void setcDao(CustomerDao cDao) 
	{
		this.cDao = cDao;
	}
	@Transactional
	public Customer createCustomer(Customer customer)
	{
		 return cDao.save(customer);
	}

	 @Transactional
	    public  String editCustomer(Customer newCustomer)
	    {
	    	Customer customer = cDao.findById(newCustomer.getEmailAddress()).get();
	    	if(customer!=null)
	    	{
	    	  customer.setFullName(newCustomer.getFullName());
	    	  customer.setPassword(newCustomer.getPassword());
	    	  customer.setPhoneNumber(newCustomer.getPhoneNumber());
	    	  customer.setAddress(newCustomer.getAddress());
	    	   customer.setCity(newCustomer.getCity());
	    	   customer.setCountry(newCustomer.getCountry());
	    	   customer.setZipCode(newCustomer.getZipCode());
	    	  return "Customer information is  Modified";
	    	}
	    	return "Update Failed";
	    }
    
	 @Transactional(readOnly=true)
		public List<Customer> getCustomers()
		{
			return cDao.findAll();
		}
		
	 @Transactional
	 public String deleteCustomer(String emailId)
	 {
		cDao.deleteById(emailId);
		return  "CUSTOMER ACCOUNT DELETED";
	 }
	 @Transactional
	 public List<Review> getReviews()
	 {
		 return rDao.findAll();
	 }
	 @Transactional
	 public Optional<List<Review>> getCustId(String emailId)
	 {
		 try
		 {
			 
			
			 return rDao.getCustId(emailId);
		 }
		 catch(NullPointerException |EmptyResultDataAccessException e)
		 {
			 System.out.println("No Review by this Customer");
			 return null;
		 }
	 }
	 @Transactional
	 public Optional<List<Order>> getCustIdByOrder(String emailId)
	 {
		 try
		 {
			
			 return oDao.getCustId(emailId);
		 }
		 catch(NullPointerException|EmptyResultDataAccessException  e)
		 {
			 System.out.println("No Orders by this Customer");
			 return null;
		 }
	 }
}
