package com.ducs.LibraryManagementApp2.repository;

import com.ducs.LibraryManagementApp2.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book, Integer> {
}
