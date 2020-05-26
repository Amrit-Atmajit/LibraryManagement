package com.library.management.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Library {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String name;

	@OneToMany(mappedBy="course")
	private List<Book> books = new ArrayList<>();
	
	@CreationTimestamp
	private LocalDateTime registeredDate;
	
	public Library() {}

	public Library(String name, List<Book> books, LocalDateTime registeredDate) {
		super();
		this.name = name;
		this.books = books;
		this.registeredDate = registeredDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void addBook(Book book) {
		this.books.add(book);
	}

	public void removeBook(Book book) {
		this.books.remove(book);
	}


	public LocalDateTime getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(LocalDateTime registeredDate) {
		this.registeredDate = registeredDate;
	}

	@Override
	public String toString() {
		return "Library [libraryId=" + id + ", name=" + name + ", books=" + books + ", registeredDate="
				+ registeredDate + "]";
	}

}