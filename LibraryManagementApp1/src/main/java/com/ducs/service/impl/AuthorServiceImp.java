package com.ducs.service.impl;

import com.ducs.dto.Author;
import com.ducs.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Component
public class AuthorServiceImp implements AuthorService {
    @Autowired
    private RestTemplate restTemplate;
    private String url = "http://localhost:8989/authors/";
    public List<Author> getAuthors() {
        List<Author> authors= restTemplate.getForObject(url,List.class);
        return authors;
    }
}
