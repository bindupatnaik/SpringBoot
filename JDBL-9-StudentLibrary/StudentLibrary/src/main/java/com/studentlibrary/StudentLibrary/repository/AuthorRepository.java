package com.studentlibrary.StudentLibrary.repository;

import com.studentlibrary.StudentLibrary.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
    @Transactional
    @Modifying
//    :#{#std.emailId}
    @Query(value= "update Author a set a.name =:#{#author.name}," +
            "a.age =:#{#author.age}," +
            "a.country =:#{#author.country}," +
            "a.email =:#{#author.email} where a.id =:#{#author.id}")
    void updateAuthor(Author author);
}
