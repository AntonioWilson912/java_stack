package com.codingdojo.bookclub.controllers;

import javax.servlet.http.HttpSession;
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

import com.codingdojo.bookclub.models.Book;
import com.codingdojo.bookclub.models.LoginUser;
import com.codingdojo.bookclub.models.User;
import com.codingdojo.bookclub.services.BookService;
import com.codingdojo.bookclub.services.UserService;

@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BookService bookService;

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "index.jsp";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session) {
		// TO-DO Later -- call a register method in the service
		// to do some extra validations and create a new user!
		User user = userService.register(newUser, result);
		
		if (result.hasErrors()) {
			// Be sure to send in the empty LoginUser before re-rendering the page.
			model.addAttribute("newLogin", new LoginUser());
			return "index.jsp";
		}
		
		// No errors!
		// TO-DO later: Store their ID from the DB in session,
		// in other words, log them in.
		session.setAttribute("userId", user.getId());
		
		return "redirect:/books";
	}
	
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model, HttpSession session) {
		// Add once service is implemented:
		User user = userService.login(newLogin, result);
		
		if (result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "index.jsp";
		}
		
		// No errors!
		// TO-DO Later: Store their ID from the DB in session.
		// in other words, log them in.
		session.setAttribute("userId", user.getId());
		
		return "redirect:/books";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		if (session.getAttribute("userId") != null) {
			session.removeAttribute("userId");
		}
		return "redirect:/";
	}
	
	@GetMapping("/books")
	public String welcome(Model model, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		
		model.addAttribute("user", userService.findUser((Long) session.getAttribute("userId")));
		model.addAttribute("books", bookService.allBooks());
		return "dashboard.jsp";
	}
	
	@GetMapping("/books/new")
	public String newBook(@ModelAttribute("book") Book book, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		return "newBook.jsp";
	}
	
	@PostMapping("/books/new")
	public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult result, HttpSession session) {
		if (result.hasErrors() ) {
			return "newBook.jsp";
		}
		
		// no errors
		book.setUser(userService.findUser((Long) session.getAttribute("userId")));
		bookService.createBook(book);
		
		return "redirect:/books";
	}
	
	@GetMapping("/books/{bookId}")
	public String showBook(@PathVariable("bookId") Long id, Model model, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		
		model.addAttribute("user", userService.findUser((Long) session.getAttribute("userId")));
		model.addAttribute("book", bookService.findBook(id));
		
		return "showBook.jsp";
	}
	
	@DeleteMapping("/books/{bookId}")
	public String deleteBook(@PathVariable("bookId") Long id) {
		bookService.deleteBook(id);
		return "redirect:/books";
	}
	
	@GetMapping("/books/{bookId}/edit")
	public String editBook(@PathVariable("bookId") Long id, Model model, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		
		model.addAttribute("book", bookService.findBook(id));
		
		return "editBook.jsp";
	}
	
	@PutMapping("/books/{bookId}/edit")
	public String updateBook(@PathVariable("bookId") Long id, @Valid @ModelAttribute("book") Book book, BindingResult result, HttpSession session) {
		if (result.hasErrors()) {
			return "editBook.jsp";
		}
		
		book.setId(id);
		book.setUser(userService.findUser((Long) session.getAttribute("userId")));
		bookService.updateBook(book);
		
		return "redirect:/books";
	}
}
