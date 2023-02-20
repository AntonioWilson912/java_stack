package com.codingdojo.mvc.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String newBookForm(@ModelAttribute("book") Book book) {
		return "new.jsp";
	}
	
	@PostMapping("")
	public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		if (result.hasErrors()) {
			return "new.jsp";
		}
		
		bookService.createBook(book);
		return "redirect:/books";
	}
	
	@GetMapping("{bookId}")
	public String showBook(@PathVariable("bookId") Long bookId, Model model) {
		Book book = bookService.findBook(bookId);
		
		model.addAttribute("book", book);
		
		return "show.jsp";
	}
	
	@GetMapping("{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		Book book = bookService.findBook(id);
		model.addAttribute("book", book);
		return "edit.jsp";
	}
	
	@PutMapping("{id}")
	public String update(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		if (result.hasErrors()) {
			return "edit.jsp";
		}
		bookService.updateBook(book);
		return "redirect:/books";
	}
	
	@DeleteMapping("{id}")
	public String destroy(@PathVariable("id") Long id) {
		bookService.deleteBook(id);
		return "redirect:/books";
	}
}
