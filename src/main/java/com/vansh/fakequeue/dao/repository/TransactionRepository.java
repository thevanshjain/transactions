package com.vansh.fakequeue.dao.repository;

import com.vansh.fakequeue.dao.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
}
