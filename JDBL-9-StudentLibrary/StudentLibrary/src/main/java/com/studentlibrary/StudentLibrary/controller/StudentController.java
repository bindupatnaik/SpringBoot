package com.studentlibrary.StudentLibrary.controller;

import com.studentlibrary.StudentLibrary.model.Student;
import com.studentlibrary.StudentLibrary.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;


    @PostMapping("/createStudent")
    public ResponseEntity createStudent(@RequestBody() Student student){
        studentService.createStudent(student);
        ResponseEntity responseEntity = new ResponseEntity<>("the student is successfully added to the system",HttpStatus.CREATED);
        return responseEntity;
    }

    @PutMapping("/updateStudent")
    public ResponseEntity updateStudent(@RequestBody() Student student){
        studentService.updateStudent(student);
        ResponseEntity responseEntity = new ResponseEntity<>("the student is successfully updated to the system",HttpStatus.ACCEPTED);
        return responseEntity;
    }


    @DeleteMapping("/deleteStudent")
    public ResponseEntity deleteStudent(@RequestParam(value = "id", required = true) int id){
        studentService.deleteStudent(id);
        return new ResponseEntity<>("student is deleted", HttpStatus.ACCEPTED);
    }

    @GetMapping("/getStudent")
    public ResponseEntity getStudent(@RequestParam(value = "name", required = false) String name){
        List<Student> studentList = studentService.getStudent(name);
        return new ResponseEntity(studentList, HttpStatus.OK);

    }



//    @DeleteMapping("/deleteStudent")
//    public ResponseEntity deleteStudent(@RequestParam("id") int student_id){
//        studentService.deleteStudentById(student_id);
//        ResponseEntity responseEntity = new ResponseEntity<>("the student is successfully deleted from the system",HttpStatus.ACCEPTED);
//        return responseEntity;
//    }
}
