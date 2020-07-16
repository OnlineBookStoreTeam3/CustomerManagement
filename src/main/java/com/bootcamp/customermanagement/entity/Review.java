package com.bootcamp.customermanagement.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="review")
public class Review 
{
	@Id
	@Column(name = "review_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int reviewId;
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne(cascade =CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
	private Book book;
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@OneToOne(cascade =CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "emailaddress")
	private Customer customer;
	@Column(length = 5, name = "rating")
    private int rating;
	@Column(length = 128, name = "headline")
    private String headline;
	@Column(length= 300, name = "comments")
    private String comment;
	
	public Review() {	}
	
	public Review(int reviewId, Book book, Customer customer, int rating, String headline, String comment) 
	{
		this.reviewId = reviewId;
		this.book = book;
		this.customer = customer;
		this.rating = rating;
		this.headline = headline;
		this.comment = comment;
	}

	public int getReviewId()
	{
		return reviewId;
	}

	public void setReviewId(int reviewId) 
	{
		this.reviewId = reviewId;
	}

	public Book getBook() 
	{
		return book;
	}

	public void setBook(Book book) 
	{
		this.book = book;
	}

	public Customer getCustomer() 
	{
		return customer;
	}

	public void setCustomer(Customer customer)
	{
		this.customer = customer;
	}

	public int getRating()
	{
		return rating;
	}

	public void setRating(int rating) 
	{
		this.rating = rating;
	}

	public String getHeadline()
	{
		return headline;
	}

	public void setHeadline(String headline) 
	{
		this.headline = headline;
	}

	public String getComment() 
	{
		return comment;
	}

	public void setComment(String comment) 
	{
		this.comment = comment;
	}
	
}
