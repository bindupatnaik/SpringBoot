package com.studentlibrary.StudentLibrary.repository;

import com.studentlibrary.StudentLibrary.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
}
