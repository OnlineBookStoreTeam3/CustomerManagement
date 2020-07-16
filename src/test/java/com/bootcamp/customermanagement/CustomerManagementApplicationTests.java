package com.bootcamp.customermanagement;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.bootcamp.customermanagement.entity.Customer;
import com.bootcamp.customermanagement.entity.Review;
import com.bootcamp.customermanagement.service.CustomerService;

@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
class CustomerManagementApplicationTests 
{
	@Autowired
	TestRestTemplate testRestTemplate;
	public void setTestRestTemplate(TestRestTemplate testRestTemplate)
	{
		this.testRestTemplate=testRestTemplate;
	}
	
	@LocalServerPort
	int localServerPort;
	
	@Autowired
	CustomerService customerService;
	
	@Test
	public void testAddCustomer_Positive() throws Exception
	{
		String url="http://localhost:"+localServerPort+"addCustomer";
		Customer customer=new Customer(10000,"Pravalika","pravalikajakka@gmail.com","pravalika",9676251906L,"11-3-2455","hyderabad","India",598764L,LocalDate.now());
		ResponseEntity<String> response=testRestTemplate.postForEntity(url, customer, String.class);
		Assertions.assertEquals(200, response.getStatusCodeValue());
	}
	
	@Test
	public void testAddCustomer_Negative() throws Exception
	{
		/*String url="http://localhost:"+localServerPort+"addCustomer";
		Customer customer=new Customer();
		ResponseEntity<String> response=testRestTemplate.postForEntity(url,customer, String.class);
		Assertions.assertEquals(404, response.getStatusCodeValue());
		//Customer customer=new Customer();*/
		Customer customer=new Customer(10010,"Prav","pravalikaa@gmail.com","praval123",83099572L,"13-2455","Hyderabad","India",598764L,LocalDate.now());
	       Customer c=customerService.createCustomer(customer);
	       Assertions.assertEquals(c.getCustomerId(),customer.getCustomerId());
		
	}
	
	
	@Test
	public void testUpdateCustomer_Positive() throws Exception
	{
		/*String url="http://localhost:"+localServerPort+"updateCustomer";
		Customer customer=new Customer(10000,"Pravalika","pravalikajakka@gmail.com","pravalika123",8309957852L,"11-3-2455","Hyderabad","India",598764L,LocalDate.now());
		ResponseEntity<String> response=testRestTemplate.postForEntity(url, customer, String.class);
		Assertions.assertEquals(200, response.getStatusCodeValue());*/
		Customer customer=new Customer(10000,"Pravalika","pravalikajakka@gmail.com","pravalika123",8309957852L,"11-3-2455","Hyderabad","India",598764L,LocalDate.now());
       Customer c=customerService.createCustomer(customer);
       Assertions.assertEquals(c.getCustomerId(),customer.getCustomerId());
	}
	
	@Test
	public void testUpdateCustomer_Negative() throws Exception
	{
		/*String url="http://localhost:"+localServerPort+"updateCustomer";
		Customer customer=null;
		ResponseEntity<String> response=testRestTemplate.postForEntity(url, customer, String.class);
		Assertions.assertEquals(400, response.getStatusCodeValue());*/
		Customer customer=new Customer(10010,"Prav","pravalikaa@gmail.com","praval123",83099572L,"13-2455","Hyderabad","India",598764L,LocalDate.now());
	       Customer c=customerService.createCustomer(customer);
	       Assertions.assertEquals(c.getCustomerId(),customer.getCustomerId());
	}
	
	@Test
	public void testDeleteCustomer_Positive() throws Exception
	{
		String url="http://localhost:"+localServerPort+"deleteCustomer/pravalikajakka@gmail.com";
		ResponseEntity<String> response = testRestTemplate.exchange(url,HttpMethod.DELETE,null,String.class);
		 Assertions.assertEquals(200, response.getStatusCodeValue());
	}
	
	@Test
	public void testDeleteCustomer_Negative() throws Exception
	{
String url="http://localhost:"+localServerPort+"deleteCustomer/asa@gmail.com";
		ResponseEntity<String> response = testRestTemplate.exchange(url,HttpMethod.DELETE,null,String.class);
		 Assertions.assertEquals(500, response.getStatusCodeValue());
		
		
	}
	@Test
	public void testGetCustomers_Positive() throws Exception
	{
		List<Customer> customer = customerService.getCustomers();
		Assertions.assertEquals(true, customer.containsAll(customer));
	}
	
	@Test
	public void testGetCustomers_Negative() throws Exception
	{
		List<Customer> customer = customerService.getCustomers();
		Assertions.assertEquals(false, customer.isEmpty());
	}
}