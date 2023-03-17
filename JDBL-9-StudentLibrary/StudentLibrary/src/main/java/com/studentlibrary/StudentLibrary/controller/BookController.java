package com.studentlibrary.StudentLibrary.controller;

import com.studentlibrary.StudentLibrary.model.Book;
import com.studentlibrary.StudentLibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/createBook")
    public ResponseEntity createBook(@RequestBody Book book){
        bookService.createBook(book);
        return new ResponseEntity("book is added successfully to Library", HttpStatus.CREATED);
    }

    @GetMapping("/getBooksByAuthor")
    public ResponseEntity getBooksByAuthor(@RequestParam(value="author", required = true) String author,
                                       @RequestParam(value="isAvailable", required = false) String isAvailable){
        List<Book> bookList = bookService.getBooksByAuthor(author, isAvailable);
        return new ResponseEntity(bookList, HttpStatus.OK);

    }

}
