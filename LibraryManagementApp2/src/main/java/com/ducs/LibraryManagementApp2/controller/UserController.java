package com.ducs.LibraryManagementApp2.controller;

import com.ducs.LibraryManagementApp2.entities.User;
import com.ducs.LibraryManagementApp2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    UserService us;

    @PostMapping(path = "/users")
    public void addUsers(@RequestBody User user) {
        us.addOrUpdate(user);
    }
    @PutMapping(path = "/users", consumes = {"application/json"})
    public void saveOrUpdateUsers(@RequestBody User user) {
        us.addOrUpdate(user);
    }

    @GetMapping(path = "/users")
    public List<User> getUsers() {
        return us.getUsers();
    }

    @RequestMapping("/users/{uname}")
    public Optional<User> getUser(@PathVariable("uname") String uname) {
        return us.getUser(uname);
    }

    @DeleteMapping("/users/{uname}")
    public void deleteUser(@PathVariable("uname") String uname) {
        us.deleteUser(uname);
    }

}
