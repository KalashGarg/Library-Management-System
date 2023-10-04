package com.ducs.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ducs.dto.Author;
import com.ducs.dto.Book;
import com.ducs.service.AuthorService;
import com.ducs.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bs;
    @Autowired
    private AuthorService as;


    @RequestMapping(value="/library")
    public ModelAndView library(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView();
        ObjectMapper mapper = new ObjectMapper();
        List<Book> books = mapper.convertValue(bs.getBooks(), new TypeReference<List<Book>>() {
        });
        mv.addObject("books", books);
        mv.setViewName("libraryhome");
        return mv;
    }

    @RequestMapping(value="/add")
    public ModelAndView add(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView();
        ObjectMapper mapper=new ObjectMapper();
        List<Author> authors= mapper.convertValue(as.getAuthors(),new TypeReference<List<Author>>(){});
        mv.addObject("authors",authors);
        mv.setViewName("addBook");
        return mv;
    }

    @RequestMapping(value="/addBooks",method= RequestMethod.POST)
    public ModelAndView addBooks(HttpServletRequest request, HttpServletResponse response,
                                 @RequestParam(value="bookcode") int bookCode, @RequestParam(value="bookname") String bookName,
                                 @RequestParam(value="author") String author, @RequestParam(value="added") String date) {
        Book b=new Book(bookCode,bookName,author,date);
        bs.addBook(b);
        ObjectMapper mapper=new ObjectMapper();
        return new ModelAndView("redirect:/library");
    }

    @RequestMapping(value="/edit")
    public ModelAndView edit(HttpServletRequest request, HttpServletResponse response) {
        Integer bookCode=Integer.parseInt(request.getParameter("id"));
        ModelAndView mv = new ModelAndView();
        ObjectMapper mapper=new ObjectMapper();
        Book book= mapper.convertValue(bs.getBook(bookCode),new TypeReference<Book>(){});
        List<Author> authors= mapper.convertValue(as.getAuthors(),new TypeReference<List<Author>>(){});
        mv.addObject("authors",authors);
        System.out.println(book.getAuthor());
        mv.addObject("book",book);
        mv.setViewName("editBook");
        return mv;
    }

    @RequestMapping(value="/editBooks",method= RequestMethod.POST)
    public ModelAndView editBooks(HttpServletRequest request, HttpServletResponse response,
                                 @RequestParam(value="bookcode") int bookCode, @RequestParam(value="bookname") String bookName,
                                 @RequestParam(value="author") String author, @RequestParam(value="added") String date) {
        ModelAndView mv = new ModelAndView();
        Book b=new Book(bookCode,bookName,author,date);
        bs.editBook(b);
        return new ModelAndView("redirect:/library");
    }

    @RequestMapping(value="/delete")
    public ModelAndView deleteBook(HttpServletRequest request, HttpServletResponse response) {
        Integer bookCode=Integer.parseInt(request.getParameter("id"));
        ModelAndView mv = new ModelAndView();
        bs.deleteBook(bookCode);
        return new ModelAndView("redirect:/library");
    }
}
