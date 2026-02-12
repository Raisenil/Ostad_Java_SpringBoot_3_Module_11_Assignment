package com.example.module_11_assignment.finance.model;

public class Transaction {
    private Long id;
    private String type;   // income or expense
    private Double amount;
    private String description;

    public Transaction() {}

    public Transaction(Long id, String type, Double amount, String description) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.description = description;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
