package com.ducs.service;

import com.ducs.dto.Book;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface BookService {
	public void addBook(Book book);
	public void editBook(Book book);
	public Book getBook(Integer id);
	public void deleteBook(Integer id);
	public List<Book> getBooks();
}
