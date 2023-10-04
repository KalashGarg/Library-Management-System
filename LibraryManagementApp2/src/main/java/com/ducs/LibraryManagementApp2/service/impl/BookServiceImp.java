package com.ducs.LibraryManagementApp2.service.impl;

import com.ducs.LibraryManagementApp2.entities.Book;
import com.ducs.LibraryManagementApp2.repository.BookRepo;
import com.ducs.LibraryManagementApp2.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public class BookServiceImp implements BookService {
    @Autowired
    BookRepo repo;

    public void addOrUpdateBook(Book book) {
        repo.save(book);
    }

    public List<Book> getBooks() {
        return repo.findAll();
    }
    public Optional<Book> getBook(Integer id) {
        return repo.findById(id);
    }

    public void deleteBook(Integer id) {
        Book book = repo.getById(id);
        repo.delete(book);
    }

}
