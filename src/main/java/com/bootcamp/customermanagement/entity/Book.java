package com.bootcamp.customermanagement.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="book")
public class Book 
{
	@Id
	@Column(name = "book_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookId;
	@Column(name = "category")
    private String category;
	@Column(name = "title")
    private String title;
	@Column(name = "author")
	private String author;
	@Column(name = "isbn_no")
    private String isbnNo;
	@Column(name = "price")
	private float price;
	
	public Book() {	}

	public Book(int bookId, String category, String title, String author, String isbnNo, float price)
	{
		this.bookId = bookId;
		this.category = category;
		this.title = title;
		this.author = author;
		this.isbnNo = isbnNo;
		this.price = price;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbnNo() {
		return isbnNo;
	}

	public void setIsbnNo(String isbnNo) {
		this.isbnNo = isbnNo;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	
	
	
	
	
}
