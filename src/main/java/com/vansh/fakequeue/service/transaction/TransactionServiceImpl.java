package com.vansh.fakequeue.service.transaction;

import com.vansh.fakequeue.dao.entity.Transaction;
import com.vansh.fakequeue.dao.repository.TransactionRepository;
import com.vansh.fakequeue.dto.TransactionDTO;
import com.vansh.fakequeue.exception.TransactionNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public ResponseEntity<TransactionDTO> addTransaction(TransactionDTO transactionDTO) {
        Transaction transaction = new Transaction();
        BeanUtils.copyProperties(transactionDTO,transaction);
        transactionRepository.save(transaction);
        return ResponseEntity.ok(transactionDTO);
    }

    @Override
    public ResponseEntity<List<TransactionDTO>> getTransaction() {
        List<Transaction> list = transactionRepository.findAll();
        if(list.isEmpty()){
            throw new TransactionNotFoundException("No transaction found!!");
        }
        List<TransactionDTO> dtoList = new ArrayList<>();
        list.forEach(transaction -> {
            TransactionDTO transactionDTO = new TransactionDTO();
            BeanUtils.copyProperties(transaction,transactionDTO);
            dtoList.add(transactionDTO);
        });
        return ResponseEntity.ok(dtoList);
    }
}
