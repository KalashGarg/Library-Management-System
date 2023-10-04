package com.ducs.LibraryManagementApp2.repository;

import com.ducs.LibraryManagementApp2.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

// spring data jpa provides full crud operations for Author entity
public interface AuthorRepo extends JpaRepository<Author, Integer> {
}
