package com.library.management.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Book {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String name;
	
	private String author;

	private String description;
	
	private Double price;

	@ManyToOne
	private Library library;

	public Book() {}

	public Book(String name, String author, String description, Double price, Library library) {
		super();
		this.name = name;
		this.author = author;
		this.description = description;
		this.price = price;
		this.library = library;
	}

	public Long getId() {
		return id;
	}

	public void setBookId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Library getLibrary() {
		return library;
	}

	public void setLibrary(Library library) {
		this.library = library;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + id + ", name=" + name + ", author=" + author + ", description=" + description
				+ ", price=" + price + ", library=" + library + "]";
	}


}