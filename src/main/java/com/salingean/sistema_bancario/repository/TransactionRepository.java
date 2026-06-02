package com.salingean.sistema_bancario.repository;

import com.salingean.sistema_bancario.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
