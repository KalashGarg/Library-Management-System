package com.ducs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.ducs.dto.Book;
import com.ducs.service.BookService;
import java.util.List;

@Component
public class BookServiceImp implements BookService{
	@Autowired
	private RestTemplate restTemplate;
	private String url = "http://localhost:8989/books/";

	public void addBook(Book book) {
		restTemplate.postForEntity(url,book,Book.class);
	}
	public void editBook(Book book) {
		restTemplate.put(url,book);
	}
	public Book getBook(Integer id) {
		Book book= (Book)restTemplate.getForObject((url+id),Book.class);
		return book;
	}

	public void deleteBook(Integer id) {
		restTemplate.delete(url+id);
	}
	public List<Book> getBooks() {
		List<Book> books= restTemplate.getForObject(url,List.class);
		return books;
	}
}
