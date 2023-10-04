package com.ducs.LibraryManagementApp2.service.impl;

import com.ducs.LibraryManagementApp2.entities.User;
import com.ducs.LibraryManagementApp2.repository.UserRepo;
import com.ducs.LibraryManagementApp2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public class UserServiceImp implements UserService {
    @Autowired
    UserRepo repo;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public void addOrUpdate(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        repo.save(user);
    }


    public List<User> getUsers() {
        return repo.findAll();
    }

    public Optional<User> getUser(String uname) {
        return repo.findById(uname);
    }

    public void deleteUser(String uname) {
        User a = repo.getById(uname);
        repo.delete(a);
    }
}
