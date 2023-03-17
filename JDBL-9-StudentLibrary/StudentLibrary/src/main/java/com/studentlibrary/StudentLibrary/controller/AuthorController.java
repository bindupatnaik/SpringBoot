package com.studentlibrary.StudentLibrary.controller;

import com.studentlibrary.StudentLibrary.model.Author;
import com.studentlibrary.StudentLibrary.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @PostMapping("/createAuthor")
    public ResponseEntity createAuthor(@RequestBody Author author){
        authorService.createAuthor(author);
        return new ResponseEntity("author is created successfully", HttpStatus.CREATED);
    }

    @PutMapping("/updateAuthor")
    public ResponseEntity updateAuthor(@RequestBody() Author author){
        authorService.updateAuthor(author);
        return new ResponseEntity("author is updated successfully", HttpStatus.ACCEPTED);
    }
}
