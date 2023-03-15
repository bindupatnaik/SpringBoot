package com.studentlibrary.StudentLibrary.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Date;

/**
 * create table student (id integer not null auto_increment, age integer, country varchar(255), created_on date, email varchar(255), name varchar(255), updated_on date, card_id integer, primary key (id)) engine=InnoDB
 * alter table student add constraint FKp33uy7j73ooyc1v7dex6s11y7 foreign key (card_id) references card (id)
 */
@Entity
public class Student {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Column(unique = true)
    private String emailId;
    private Integer age;
    private String country;

    @OneToOne
    @JoinColumn
    private Card card;

    @CreationTimestamp
    private Date createdOn;


    @UpdateTimestamp
    private Date updatedOn;

    public Student(){

    }
    public Student(String name, Integer age, String email, String country) {
        this.name = name;
        this.emailId = email;
        this.age = age;
        this.country = country;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + emailId + '\'' +
                ", age=" + age +
                ", country='" + country + '\'' +
                ", createdOn=" + createdOn +
                ", updatedOn=" + updatedOn +
                '}';
    }
}
