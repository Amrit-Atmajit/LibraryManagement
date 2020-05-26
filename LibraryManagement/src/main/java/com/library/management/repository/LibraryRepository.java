package com.library.management.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.library.management.entity.Book;
import com.library.management.entity.Library;

@Repository
@Transactional
public class LibraryRepository {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private EntityManager em;

	public Library findLibraryById(Long id) {
		Library library = em.find(Library.class, id);
		logger.info("Library -> {}", library);
		return library;
	}

	public Library saveLibrary(Library library) {

		if (library.getId() == null) {
			em.persist(library);
		} else {
			em.merge(library);
		}

		return library;
	}

	public void deleteLibraryById(Long id) {
		Library library = findLibraryById(id);
		em.remove(library);
	}
	
	public Book findBookById(Long id) {
		Book book = em.find(Book.class, id);
		logger.info("Book -> {}", book);
		return book;
	}

	public Book saveBook(Book book) {
		if (book.getId() == null) {
			em.persist(book);
		} else {
			em.merge(book);
		}

		return book;
	}

	public void deleteBookById(Long id) {
		Book book = findBookById(id);
		em.remove(book);
	}
	
	public void addBooksForLibrary(Long libraryId, List<Book> books) {		
		Library library = findLibraryById(libraryId);
		logger.info("library.getBooks() -> {}", library.getBooks());
		for(Book book : books)
		{			
			//setting the relationship
			library.addBook(book);
			book.setLibrary(library);
			em.persist(book);
		}
	}
}