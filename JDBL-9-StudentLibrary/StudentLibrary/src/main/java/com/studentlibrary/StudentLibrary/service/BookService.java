package com.studentlibrary.StudentLibrary.service;

import com.studentlibrary.StudentLibrary.model.Book;
import com.studentlibrary.StudentLibrary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;
    public void createBook(Book book) {
        bookRepository.save(book);
    }

    public List<Book> getBooksByAuthor(String author, String isAvailable) {
        if (isAvailable == null){
            return bookRepository.getBooksByAuthorOnly(author);
        }else{
            return bookRepository.getBooksByAuthorBasedOnAvailability(author, Boolean.valueOf(isAvailable));
        }

    }
}
