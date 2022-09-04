package com.vansh.fakequeue.service.transaction;

import com.vansh.fakequeue.dao.entity.Transaction;
import com.vansh.fakequeue.dao.repository.TransactionRepository;
import com.vansh.fakequeue.dto.TransactionDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public ResponseEntity<String> addTransaction(TransactionDTO transactionDTO) {
        Transaction transaction = new Transaction();
        BeanUtils.copyProperties(transactionDTO,transaction);
        transactionRepository.save(transaction);
        return ResponseEntity.ok("Transaction added Successfully!");
    }

    @Override
    public ResponseEntity<List<TransactionDTO>> getTransaction() {
        List<Transaction> list = transactionRepository.findAll();
        List<TransactionDTO> dtoList = new ArrayList<>();
        list.forEach(transaction -> {
            TransactionDTO transactionDTO = new TransactionDTO();
            BeanUtils.copyProperties(transaction,transactionDTO);
            dtoList.add(transactionDTO);
        });
        return ResponseEntity.ok(dtoList);
    }

    @Override
    public ResponseEntity<String> deleteTransaction(int id) {
        Optional<Transaction> transaction = transactionRepository.findById(id);
        if(transaction.isPresent()){
            transactionRepository.deleteById(id);
            return ResponseEntity.ok("Delete Successful!");
        }
        return ResponseEntity.ok("transaction not found!");
    }

    @Override
    public ResponseEntity<String> modifyTransaction(int id, TransactionDTO transactionDTO) {
        Optional<Transaction> result = transactionRepository.findById(id);

        if (result.isPresent()) {
            Transaction transaction = result.get();
            BeanUtils.copyProperties(transactionDTO,transaction,"id");
            transactionRepository.save(transaction);
            return ResponseEntity.ok("Transaction Modified");
        }
        return ResponseEntity.ok("Transaction not found");

    }

    @Override
    public ResponseEntity<?> getTransactionById(Integer id) {
        Optional<Transaction> result = transactionRepository.findById(id);
        if(result.isPresent()){
            TransactionDTO transactionDTO = new TransactionDTO();
            BeanUtils.copyProperties(result.get(),transactionDTO);
            return ResponseEntity.ok(transactionDTO);
        }
        return ResponseEntity.ok("Transaction Not Found!");
    }

}
