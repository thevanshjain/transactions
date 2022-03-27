package com.vansh.fakequeue.service.transaction;

import com.vansh.fakequeue.dao.entity.Transaction;
import com.vansh.fakequeue.dto.TransactionDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TransactionService {

    ResponseEntity<TransactionDTO> addTransaction(TransactionDTO transactionDTO);

    ResponseEntity<List<TransactionDTO>> getTransaction();
}
