package com.studentlibrary.StudentLibrary.repository;

import com.studentlibrary.StudentLibrary.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface StudentRepository extends JpaRepository<Student, Integer> {
    //JPQL approach
    @Query("select b from Student b where b.emailId=:email")
    public List<Student> findStudentByEmail(String email);
    //Native SQL
    @Query(value = "select * from Student s where s.email_Id=:email", nativeQuery = true)
    public List<Student> findStudentByEmailSQL(String email);


    @Modifying
    @Query(value="update Student s set s.emailId=:newEmail where s.emailId=:oldEmail")
    public int updateStudentEmail(String oldEmail, String newEmail);



    @Modifying
    @Query(value="update Student s set s.emailId=:#{#std.emailId}, s.name=:#{#std.name}, s.age=:#{#std.age}, s.country=:#{#std.country} where s.id=:#{#std.id}")
//    @Query(value="update Student s set s.emailId=:#{#std.emailId} where s.id=:id")
    public void updateStudentInfo( Student std);


    @Modifying
    @Query("delete from Student s where s.id =:id")
    void deleteStudent(int id);
}
