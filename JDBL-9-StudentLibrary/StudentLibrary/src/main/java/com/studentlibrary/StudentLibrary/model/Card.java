package com.studentlibrary.StudentLibrary.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

/**
 * create table card (id integer not null auto_increment, created_on date, updated_on date, primary key (id)) engine=InnoDB
 *
 *
 *      *
 *      * Eager and lazy with one to many annotation. it works fine with onetoone mapping
 *      * Eager
 *      * System.out.println("id = "+card1.getId() +"========>students "+card1.getStudents());
 *      * id = 1========>students [Student{id=1, name='Bindu', email='quest4bindu@gmail.com', age=20, country='India', createdOn=2023-03-12, updatedOn=2023-03-12}, Student{id=2, name='Siri', email='quest4bindu@gmail.com', age=20, country='India', createdOn=2023-03-12, updatedOn=2023-03-12}, Student{id=3, name='Praveen', email='quest4bindu@gmail.com', age=20, country='India', createdOn=2023-03-12, updatedOn=2023-03-12}]
 *      *
 *      * Lazy
 *      * Caused by: org.hibernate.LazyInitializationException: failed to lazily initialize a collection of role: com.studentlibrary.StudentLibrary.model.Card.students, could not initialize proxy - no Session
 *
 */
@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


//    @OneToOne(mappedBy = "card", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private Student student;



    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Book> booksIssued;

//    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL,  fetch = FetchType.LAZY)
//    private List<Student> students;

    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date updatedOn;

    @Enumerated(value=EnumType.STRING)
    private CardStatus cardStatus;

    public CardStatus getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(CardStatus cardStatus) {
        this.cardStatus = cardStatus;
    }


    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//    public Student getStudent() {
//        return student;
//    }

//    public void setStudent(Student student) {
//        this.student = student;
//    }
    public List<Book> getBooksIssued() {
        return booksIssued;
    }

    public void setBooksIssued(List<Book> booksIssued) {
        this.booksIssued = booksIssued;
    }

//    public List<Student> getStudents() {
//        return students;
//    }
//
//    public void setStudents(List<Student> students) {
//        this.students = students;
//    }


    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                //", student=" + student +
                ", createdOn=" + createdOn +
                ", updatedOn=" + updatedOn +
                ", cardStatus=" + cardStatus +
                '}';
    }
}
