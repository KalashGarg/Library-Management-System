package com.ducs.LibraryManagementApp2.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
@Entity
public class Book {
    @Id
    private int bookCode;
    private String bookName;
    private String author;
    private String date;
    public Book(){

    }

    public Book(int bookCode, String bookName, String author, String date) {
        this.bookCode = bookCode;
        this.bookName = bookName;
        this.author = author;
        this.date = date;
    }

    public int getBookCode() {
        return bookCode;
    }

    public void setBookCode(int bookCode) {
        this.bookCode = bookCode;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}