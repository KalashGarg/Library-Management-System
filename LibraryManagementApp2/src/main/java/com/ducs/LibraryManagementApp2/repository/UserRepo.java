package com.ducs.LibraryManagementApp2.repository;

import com.ducs.LibraryManagementApp2.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface
UserRepo extends JpaRepository<User, String>{
}
