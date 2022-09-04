package com.vansh.fakequeue.service.transaction;

import com.vansh.fakequeue.dto.TransactionDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TransactionService {

    ResponseEntity<String> addTransaction(TransactionDTO transactionDTO);

    ResponseEntity<List<TransactionDTO>> getTransaction();

    ResponseEntity<String> deleteTransaction(int id);

    ResponseEntity<String> modifyTransaction(int id, TransactionDTO transactionDTO);

    ResponseEntity<?> getTransactionById(Integer id);
}
