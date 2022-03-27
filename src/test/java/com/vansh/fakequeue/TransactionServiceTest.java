package com.vansh.fakequeue;

import com.vansh.fakequeue.dao.entity.Transaction;
import com.vansh.fakequeue.dao.repository.TransactionRepository;
import com.vansh.fakequeue.dto.TransactionDTO;
import com.vansh.fakequeue.service.transaction.TransactionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TransactionServiceTest {

    @MockBean
    private TransactionRepository transactionRepository;

    @Autowired
    private TransactionService transactionService;

    private TransactionDTO getTransactionDTO(){
        TransactionDTO transactionDTO = new TransactionDTO();
        transactionDTO.setAccountNumber(123L);
        transactionDTO.setType("Credit");
        transactionDTO.setAmount(10000L);
        transactionDTO.setCurrency("INR");
        transactionDTO.setAccountFrom(345L);
        return transactionDTO;
    }

    private Transaction getTransaction(){
        Transaction transaction = new Transaction();
        transaction.setAccountNumber(123L);
        transaction.setType("Credit");
        transaction.setAmount(10000L);
        transaction.setCurrency("INR");
        transaction.setAccountFrom(345L);
        return transaction;
    }

    @Test
    void testGetTransaction(){
        Transaction transaction = getTransaction();
        List<Transaction> transactions = Collections.singletonList(transaction);
        when(transactionRepository.findAll()).thenReturn(transactions);
        ResponseEntity<List<TransactionDTO>> transactionDTOResponseEntity =transactionService.getTransaction();
        assertEquals(1, Objects.requireNonNull(transactionDTOResponseEntity.getBody()).size());
    }

    @Test()
    void testAddTransaction(){
        Transaction transaction = getTransaction();
        TransactionDTO transactionDTO = getTransactionDTO();
        when(transactionRepository.save(transaction)).thenReturn(transaction);
        ResponseEntity<TransactionDTO> responseEntity = transactionService.addTransaction(transactionDTO);
        assertEquals("Credit", responseEntity.getBody().getType());
    }






}
