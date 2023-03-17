package com.studentlibrary.StudentLibrary.controller;

import com.studentlibrary.StudentLibrary.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @PostMapping("/issueBook")
    public ResponseEntity issueBook(@RequestParam("cardId") int cardId,
                                    @RequestParam("bookId") int bookId) throws Exception {
        String externalTransactionId = transactionService.issueBook(cardId, bookId);
        return new ResponseEntity<>("transaction is complete, here is your transaction id"+externalTransactionId, HttpStatus.OK);
    }
}
