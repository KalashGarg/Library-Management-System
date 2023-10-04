package com.ducs.LibraryManagementApp2.service;

import com.ducs.LibraryManagementApp2.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    public void addOrUpdate(User user);
    public List<User> getUsers();
    public Optional<User> getUser(String uname);
    public void deleteUser(String uname);
}
