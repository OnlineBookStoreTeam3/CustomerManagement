package com.bootcamp.customermanagement.dao;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bootcamp.customermanagement.entity.Review;

@Repository
public interface ReviewDao extends JpaRepository<Review, Integer>
{
	@Query("select r from Review r where r.customer.emailAddress=:emailId")
	public Optional<List<Review>> getCustId(@Param("emailId") String emailId);
}
