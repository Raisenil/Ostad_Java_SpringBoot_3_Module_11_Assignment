package com.example.module_11_assignment.finance.contoller;

import com.example.module_11_assignment.finance.model.Transaction;
import com.example.module_11_assignment.finance.service.TransactionService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    private final TransactionService service;

    public TransactionController(TransactionService service) {
        this.service = service;
    }

    // GET all transactions
    @GetMapping
    public List<Transaction> getAllTransactions(
            @RequestParam(required = false) String type) {

        if (type != null) {
            return service.getTransactionsByType(type);
        }

        return service.getAllTransactions();
    }

    // GET transaction by id
    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable Long id) {
        return service.getTransactionById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST - Add new transaction
    @PostMapping
    public Transaction addTransaction(@RequestBody Transaction transaction) {
        return service.addTransaction(transaction);
    }

    // DELETE by id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTransaction(@PathVariable Long id) {
        boolean deleted = service.deleteTransaction(id);

        if (deleted) {
            return ResponseEntity.ok("Transaction with id " + id + " deleted successfully");
        }

        return ResponseEntity.status(404).body("Transaction with id " + id + " not found");
    }

    @RestController
    public static class HomeController {

        @GetMapping(value = "/", produces = MediaType.TEXT_PLAIN_VALUE)
        public String welcome() {
            return "Welcome to Finance application";
        }
    }
}
