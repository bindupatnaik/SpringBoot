package com.studentlibrary.StudentLibrary.service;

import com.studentlibrary.StudentLibrary.model.Card;
import com.studentlibrary.StudentLibrary.model.CardStatus;
import com.studentlibrary.StudentLibrary.model.Student;
import com.studentlibrary.StudentLibrary.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService {

    @Autowired
    CardRepository cardRepository;

    public Card createAndGetCard(Student student) {
        Card card = new Card();
//        card.setStudent(student);
        student.setCard(card);
        card.setCardStatus(CardStatus.ACTIVATED);
        cardRepository.save(card);
        return card;
    }



//    public void deactivateCard(int student_id) {
//        cardRepository.deactivateCardOfStudentById(student_id, CardStatus.DEACTIVATED.toString());
//    }
}
