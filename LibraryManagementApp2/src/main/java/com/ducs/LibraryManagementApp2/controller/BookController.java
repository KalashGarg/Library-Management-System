package com.ducs.LibraryManagementApp2.controller;


import com.ducs.LibraryManagementApp2.service.BookService;
import com.ducs.LibraryManagementApp2.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    BookService bs;

    @PostMapping(path = "/books")
    public void addBooks(@RequestBody Book book) {
        bs.addOrUpdateBook(book);
    }

    @PutMapping(path = "/books")
    public void saveOrUpdateBooks(@RequestBody Book book) {
        bs.addOrUpdateBook(book);
    }

    @GetMapping(path = "/books")
    public List<Book> getBooks() {
        return bs.getBooks();
    }

    @RequestMapping("/books/{id}")
    public Optional<Book> getBook(@PathVariable("id") Integer id) {
        return bs.getBook(id);
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable("id") Integer id) {
        bs.deleteBook(id);
    }
}
