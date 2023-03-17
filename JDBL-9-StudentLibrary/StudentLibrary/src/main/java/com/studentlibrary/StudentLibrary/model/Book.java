package com.studentlibrary.StudentLibrary.model;

import javax.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToOne
    @JoinColumn
    private Author author;
    @Enumerated(value=EnumType.STRING)
    private Genre genre;

    @Column(columnDefinition = "TINYINT(1)")
    private boolean isAvailable;

    @ManyToOne
    @JoinColumn
    private Card card;

    public Book(){

    }

    public Book(String name, Author author, Genre genre) {
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.isAvailable = true;
    }

//    public Book(String name, Genre genre) {
//        this.name = name;
//        this.genre = genre;
//        this.isAvailable = true;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }



}
