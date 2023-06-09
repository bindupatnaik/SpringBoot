package com.studentlibrary.StudentLibrary.repository;

import com.studentlibrary.StudentLibrary.model.Card;
import com.studentlibrary.StudentLibrary.model.CardStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {
    @Modifying
    @Transactional
    @Query(value = "update Card c set c.cardStatus =:status where c.id in (select card from Student s where s.id =:student_id)")
    //, nativeQuery = true
    void deactivateCard(int student_id, CardStatus status);

//    @Transactional
//    @Modifying
//    //@Query(value = "update Card set cardStatus =:status where id in (select cardId from student where id =:student_id)", nativeQuery = true)
//    //@Query(value = "delete from card where card_status=:status and id=:student_id", nativeQuery = true)
//    @Query(value = "update card c set c.card_status =:status where c.id in (select card_id from student s where s.id =:student_id)", nativeQuery = true)
//    void deactivateCardOfStudentById(int student_id, String status);
}
