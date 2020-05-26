package com.library.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.management.entity.Book;
import com.library.management.entity.Library;
import com.library.management.repository.LibraryRepository;

@Service
public class LibraryService {
	
	@Autowired
	LibraryRepository libraryRepository;
	
	public Library findLibraryById(Long id) {
		Library library = libraryRepository.findLibraryById(id);
		return library;
	}

	public Library saveLibrary(Library library) {
		libraryRepository.saveLibrary(library);
		return library;
	}

	public void deleteLibraryById(Long id) {
		libraryRepository.deleteLibraryById(id);
	}
	
	public Book findBookById(Long id) {
		Book book = libraryRepository.findBookById(id);
		return book;
	}

	public Book saveBook(Book book) {
		libraryRepository.saveBook(book);
		return book;
	}

	public void deleteBookById(Long id) {
		libraryRepository.deleteBookById(id);
	}
	
	public void addBooksForLibrary(Long libraryId, List<Book> books) {		
		libraryRepository.addBooksForLibrary(libraryId, books);
	}

}
