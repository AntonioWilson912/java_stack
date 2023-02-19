package com.codingdojo.mvc.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.mvc.models.Book;
import com.codingdojo.mvc.services.BookService;

@Controller
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping("")
	public String index(Model model) {
		ArrayList<Book> books = (ArrayList<Book>) bookService.allBooks();
		model.addAttribute("books", books);
		return "index.jsp";
	}
	
	@GetMapping("/new")
	public String newBookForm() {
		return "new.jsp";
	}
	
	@PostMapping("")
	public String create(@RequestParam("title") String title,
			@RequestParam("description") String description,
			@RequestParam("language") String language,
			@RequestParam("numberOfPages") Integer numberOfPages) {
		
		Book book = new Book(title, description, language, numberOfPages);
		
		bookService.createBook(book);
		
		return "redirect:/books";
	}
	
	@GetMapping("{bookId}")
	public String showBook(@PathVariable("bookId") Long bookId, Model model) {
		Book book = bookService.findBook(bookId);
		
		model.addAttribute("book", book);
		
		return "show.jsp";
	}
}
