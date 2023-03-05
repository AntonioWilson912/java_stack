package com.codingdojo.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.bookclub.models.Book;
import com.codingdojo.bookclub.models.User;
import com.codingdojo.bookclub.repositories.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	public List<Book> allBooks() {
		return bookRepository.findAll();
	}
	
	public Book findBook(Long id) {
		Optional<Book> book = bookRepository.findById(id);
		if (book.isPresent() ) {
			return book.get();
		}
		
		return null;
	}
	
	public List<Book> findAllAvailableBooks() {
		return bookRepository.findByBorrowerIsNull();
	}
	
	public void borrowBook(Long bookId, User user) {
		Book book = findBook(bookId);
		book.setBorrower(user);
		bookRepository.save(book);;
	}
	
	public void returnBook(Long bookId) {
		Book book = findBook(bookId);
		book.setBorrower(null);
		bookRepository.save(book);;
	}
	
	public Book createBook(Book book) {
		return bookRepository.save(book);
	}
	
	public Book updateBook(Book book) {
		return bookRepository.save(book);
	}
	
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}
}
