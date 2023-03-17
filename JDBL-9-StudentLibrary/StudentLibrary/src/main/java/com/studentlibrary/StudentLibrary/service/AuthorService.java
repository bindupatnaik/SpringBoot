package com.studentlibrary.StudentLibrary.service;

import com.studentlibrary.StudentLibrary.model.Author;
import com.studentlibrary.StudentLibrary.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    public void createAuthor(Author author) {
        authorRepository.save(author);
    }

    public void updateAuthor(Author author) {
        authorRepository.updateAuthor(author);
    }
}
