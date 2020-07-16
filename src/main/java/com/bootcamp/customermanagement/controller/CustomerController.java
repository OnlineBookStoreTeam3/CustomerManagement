package com.bootcamp.customermanagement.controller;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.hibernate.query.criteria.internal.expression.SearchedCaseExpression.WhenClause;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.customermanagement.entity.Customer;
import com.bootcamp.customermanagement.entity.Review;
import com.bootcamp.customermanagement.service.CustomerService;

@RestController
public class CustomerController 
{
	 @Autowired
	 CustomerService customerService;
	 public void setCustomerService(CustomerService customerService) 
	 { 
		 this.customerService = customerService; 
		 
	 }
	 @PostMapping(value="/addCustomer",consumes="application/json")
	    public ResponseEntity<String> addCustomerDetails(@RequestBody() Customer customer)
	    {
	  	  try
	  	  {
	  		  customer.setRegisterDate(LocalDate.now());
	  	      customerService.createCustomer(customer);
	  	      return new ResponseEntity<String>("Customer Added",HttpStatus.OK);
	  	  }
	  	  catch(Exception ex)
	  	  {
	  	    	return new ResponseEntity<String>(ex.getMessage()+" Customer Already Exists",HttpStatus.BAD_REQUEST);
	  	  } 
	    }
	 
	 @PutMapping(value="/updateCustomer",consumes="application/json")
	    public String updateCustomer(@RequestBody()Customer customer)
	    {
	 	   String message=customerService.editCustomer(customer);
	 	   return message;
	    }
		
	 @GetMapping(value="/getCustomers",produces="application/json")
	    public List<Customer> getCustomerDetails()
	    {
	  	  return customerService.getCustomers();
	    }
	 @DeleteMapping(value="/deleteCustomer/{emailId}",produces="application/json")
	  public void deleteCustomer(@PathVariable String emailId)
	  {
		 System.out.println(emailId);
		 Optional<List<Review>> r = customerService.getCustId(emailId);
		 try
		 {
		 
		 if(r==null)
		 {
			 System.out.println(customerService.deleteCustomer(emailId));
		 }
		 else
			 System.out.println("Cannot be deleted");
	  }
	 catch(NullPointerException s)
		 {
		  System.out.println("Account didn't exist");
		 }
		
	 }
	    
	}

	 
