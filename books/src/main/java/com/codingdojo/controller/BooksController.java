package com.codingdojo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.models.Book;
import com.codingdojo.services.BookService;

@SpringBootApplication
@Controller
public class BooksController {
	
	@Autowired
	BookService bookService;
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/books/new")
	public String newbook() {
		return "new.jsp";
	}
	
	
	@RequestMapping("/book/{id}")
	public String singleBook(@PathVariable("id") Long bookId,Model model ) {
		
		Book book = bookService.findBook(bookId);
		model.addAttribute("book",book);
		return "book.jsp";
	}
	
	@RequestMapping("/books")
	public String books(Model model ) {
		
		List<Book> books = bookService.allBooks();
        model.addAttribute("books", books);
      
		return "books.jsp";
	}
	
	// Note: We'll be altering this a bit after we introduce data binding.
	@PostMapping("/books/add")
	public String create(
	    @RequestParam("title") String title,
	    @RequestParam("description") String description,
	    @RequestParam("language") String language,
	    @RequestParam("pages") Integer pages) 
	{
	    // CODE TO MAKE A NEW BOOK AND SAVE TO THE DB
	    Book book = new Book(title, description, language, pages);
	    bookService.createBook(book);
	    return "redirect:/books";
	}





}
