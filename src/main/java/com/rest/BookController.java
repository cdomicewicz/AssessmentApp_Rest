//BookApplication_Rest
package com.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.model.util.Book;

import static com.model.util.Book.*;

@RestController

public class BookController {

//	http://localhost:8181/getBooks
	//This method read all books from static field allBooks in class Book and return it as JSON
	@RequestMapping(value = "/getBooks", method = RequestMethod.GET)
	public ResponseEntity<List<Book>> getBooks() {
		final List<Book> books = Book.getAllBooks();
		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
	}
//	http://localhost:8181/addBook
//	JSON Example:
//	{"author" : "Cezary Domicewicz", "title" : "My first book", "isbn" : "12345678"}
//This class adds new book if name put by user is correct (one of the words starts with capital "A")
	@PostMapping("/addBook")
	public String addBook(@RequestBody Book book) {
		String author = book.getAuthor();
		String title = book.getTitle();
		String isbn = book.getIsbn();
		if (validateName(author)) {
			createBook(author, title, isbn);
			//Message about added book is send back
			return "\"" + title + "\" by " + author + " (ISBN: " + isbn + ") was added!";
		} else {
			//Message about wrong author is send back
			return "Invalid author: " + author + "!";
		}
	}

}
