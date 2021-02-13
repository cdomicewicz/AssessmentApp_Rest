package com.model.util;

import java.util.ArrayList;
import java.util.List;

//This class creates Book objects, collects them in allBooks static list. Also provides methods to validate some book entries
public class Book {
	private String author;
	private String title;
	private String isbn;
	private static List<Book> allBooks = new ArrayList<>();

	private Book(String author, String title, String isbn) {
		super();
		this.author = author;
		this.title = title;
		this.isbn = isbn;
	}

	
	public static Book createBook(String author, String title, String isbn) {
		Book newBook = new Book(author, title, isbn);
			if (!allBooks.isEmpty()) {
			boolean canBookBeAdded = true;
			for (Book book : allBooks) {
				if (book.equals(newBook)) {
					canBookBeAdded = false;
				}
			} 
			if (canBookBeAdded) {
				allBooks.add(newBook);
			}
		} else {
			allBooks.add(newBook);
		}
		return newBook;
	}

	public static List<Book> getAllBooks() {
		return allBooks;
	}

	public String getAuthor() {
		return author;
	}

	public String getTitle() {
		return title;
	}

	public String getIsbn() {
		return isbn;
	}
	
	public boolean equals(Book book) {
		return this.author.equals(book.getAuthor()) && this.title.equals(book.getTitle()) && this.isbn.equals(book.getIsbn()); 
	}
	
	//Check if entry is valid
	private static boolean isValid(String word) {
		return word != null && !word.isEmpty() ? true : false;
	}

	//Check if entry is valid. When not, optionalMessage is returned
	public static String checkEntry(String entry, String optionalMessage) {
		return isValid(entry) ? entry : optionalMessage;
	}
	
	/*Name is valid when consists of minimum two words separated by space character.
	 * One of the words must start with capital "A"
	 * Otherwise method return false
	 **/ 
	public static boolean validateName(String inputName) {
		String[] split = inputName.split(" ");
		if (split.length >= 2) {
			String forename = split[0];
			String name = split[1];
			if (forename.startsWith("A") || name.startsWith("A")) {
				return true;
			}
		}
		return false;
	};

	//Full name gets first word and second word from inputName. They are returned in String
	public static String getFullName(String inputName) {
		String fullName = inputName;
		if (!isValid(inputName)) {
			return fullName;
		}
		String forename;
		String name;
		try {
			if (validateName(inputName)) {
				String[] split = inputName.split(" ");
				forename = split[0];
				name = split[1];
				fullName = forename + " " + name;
				return fullName;
			}

		} catch (Exception e) {
			return fullName;
		}
		return fullName;

	}

}
