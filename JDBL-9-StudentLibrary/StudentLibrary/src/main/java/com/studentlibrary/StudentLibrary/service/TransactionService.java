package com.studentlibrary.StudentLibrary.service;

import com.studentlibrary.StudentLibrary.model.*;
import com.studentlibrary.StudentLibrary.repository.BookRepository;
import com.studentlibrary.StudentLibrary.repository.CardRepository;
import com.studentlibrary.StudentLibrary.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

//    public static final int max_allowed = 3

    @Autowired
    BookRepository bookRepository;

    @Autowired
    CardRepository cardRepository;

    @Autowired
    TransactionRepository transactionRepository;

    @Value("${books.max_allowed}")

    public String issueBook(int cardId, int bookId) throws Exception {
        Book book = bookRepository.findById(bookId).get();
        Card card = cardRepository.findById(cardId).get();

        Transaction transaction = new Transaction();
        transaction.setBook(book);
        transaction.setCard(card);
        transaction.setIssueOperation(true);

        //if there is no such book or book is not available
        if (book == null || !book.isAvailable()){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Book is either not present or available");
        }
        if(card == null || card.getCardStatus().equals(CardStatus.DEACTIVATED)){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Either card is not present or card is deactivated");
        }

//       if( card.getBooksIssued().size() >= 3){
//           transaction.setTransactionStatus(TransactionStatus.FAILED);
//           transactionRepository.save(transaction);
//           throw new Exception("Book limit for this card is reached. No more books can be issued");
//       }

       //Code is still under development
        return transaction.getTransactionId();
    }
}
