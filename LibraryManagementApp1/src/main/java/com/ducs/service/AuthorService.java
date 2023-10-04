package com.ducs.service;

import com.ducs.dto.Author;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AuthorService {
    public List<Author> getAuthors();
}
