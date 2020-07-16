package com.bootcamp.customermanagement.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bootcamp.customermanagement.entity.Customer;
@Repository
public interface CustomerDao extends JpaRepository<Customer,String> 
{

}
