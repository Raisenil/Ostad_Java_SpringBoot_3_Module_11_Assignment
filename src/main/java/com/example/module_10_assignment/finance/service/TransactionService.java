package com.example.module_10_assignment.finance.service;

import com.example.module_10_assignment.finance.model.Transaction;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TransactionService {
    private final List<Transaction> transactions = new ArrayList<>();
    private Long currentId = 1L;

    // GET all transactions
    public List<Transaction> getAllTransactions() {
        return transactions;
    }

    // GET by id using Stream API
    public Optional<Transaction> getTransactionById(Long id) {
        return transactions.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst();
    }

    // POST - add new transaction
    public Transaction addTransaction(Transaction transaction) {
        transaction.setId(currentId++);
        transactions.add(transaction);
        return transaction;
    }

    // DELETE by id using Stream API
    public boolean deleteTransaction(Long id) {
        return transactions.removeIf(t -> t.getId().equals(id));
    }

    // OPTIONAL - filter by type using Stream API
    public List<Transaction> getTransactionsByType(String type) {
        return transactions.stream()
                .filter(t -> t.getType().equalsIgnoreCase(type))
                .collect(Collectors.toList());
    }
}
