package com.studentlibrary.StudentLibrary.service;

import com.studentlibrary.StudentLibrary.model.Card;
import com.studentlibrary.StudentLibrary.model.Student;
import com.studentlibrary.StudentLibrary.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private static Logger logger = LoggerFactory.getLogger(StudentService.class);
    @Autowired
    CardService cardService;

    @Autowired
    StudentRepository studentRepository;

    public void createStudent(Student student){
        Card card = cardService.createAndGetCard(student);
        studentRepository.save(student);//it is redundant. you dont need to save student explicitly.
        logger.info("the card for the student {} created with the details {}", student, card);
    }

    public void updateStudent( Student student) {
        studentRepository.updateStudentInfo(student);

    }

    public void deleteStudent(int id){
        cardService.deactivateCard(id);
        studentRepository.deleteStudent(id);
//        studentRepository.deleteById(id);
    }

//    public void deleteStudentById(int student_id) {
//        //before deleting student id from table deactivate the card
//        cardService.deactivateCard(student_id);
//        studentRepository.deleteById(student_id);
//    }
}
