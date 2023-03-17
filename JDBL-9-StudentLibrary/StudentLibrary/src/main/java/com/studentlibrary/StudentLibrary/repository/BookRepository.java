package com.studentlibrary.StudentLibrary.repository;

import com.studentlibrary.StudentLibrary.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

//    @Query("select b from Book b where b.author in (select a.id from Author a where a.name=:author)")
    @Query(value = "select * from book b where b.author_id in (select a.id from author a where a.name=:author)", nativeQuery = true)
    List<Book> getBooksByAuthorOnly(String author);

    @Query("select b from Book b where b.author in (select a.id from Author a where a.name=:author) and b.isAvailable=:isAvailable")
    List<Book> getBooksByAuthorBasedOnAvailability(String author, boolean isAvailable);
}
