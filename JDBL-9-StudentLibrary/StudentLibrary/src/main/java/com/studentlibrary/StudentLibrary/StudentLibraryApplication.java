package com.studentlibrary.StudentLibrary;

import com.studentlibrary.StudentLibrary.repository.CardRepository;
import com.studentlibrary.StudentLibrary.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * create table card (id integer not null auto_increment, created_on date, updated_on date, primary key (id)) engine=InnoDB
 * create table student (id integer not null auto_increment, age integer, country varchar(255), created_on date, email varchar(255), name varchar(255), updated_on date, card_id integer, primary key (id)) engine=InnoDB
 * alter table student add constraint FKp33uy7j73ooyc1v7dex6s11y7 foreign key (card_id) references card (id)
 */


@SpringBootApplication
public class StudentLibraryApplication implements CommandLineRunner {
	@Autowired
	StudentRepository studentRepository;

	@Autowired
	CardRepository cardRepository;

	public static void main(String[] args) {
		SpringApplication.run(StudentLibraryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Student student1 = new Student("Bindu", 20, "quest4bindu@gmail.com", "India");
//		Card card = new Card();
//		card.setStudent(student1);
//		student1.setCard(card);
//		cardRepository.save(card);
//		studentRepository.save(student1);

//		System.out.println(studentRepository.findStudentByEmail("quest4bindu@gmail.com"));
//		System.out.println(studentRepository.findStudentByEmailSQL("quest4bindu@gmail.com"));
//		System.out.println(studentRepository.updateStudentEmail("quest4bindu@gmail.com", "praveen.killamsetting@gmail.com"));

//		Student student2 = new Student("Siri", 20, "quest4bindu@gmail.com", "India");
//		Student student3 = new Student("Praveen", 20, "quest4bindu@gmail.com", "India");
//		card.setStudents(Arrays.asList(student1, student2, student3));
//		student2.setCard(card);
//		student3.setCard(card);
//      to insert records in DB
//		studentRepository.save(student2);
//		studentRepository.save(student3);
		//to get data from Database
		//Card card1 = cardRepository.findById(1).get();
		//System.out.println("id = "+card1.getId() +"========>students "+card1.getStudents());


	}
}
