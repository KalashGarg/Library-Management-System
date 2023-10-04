package com.ducs.LibraryManagementApp2.service;

import com.ducs.LibraryManagementApp2.entities.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BookService {
    public void addOrUpdateBook(Book book);
    public List<Book> getBooks();
    public Optional<Book> getBook(Integer id);
    public void deleteBook(Integer id);


}
