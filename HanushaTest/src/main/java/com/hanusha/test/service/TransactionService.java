package com.hanusha.test.service;

import com.hanusha.test.model.Period;
import com.hanusha.test.model.Reward;
import com.hanusha.test.model.Transaction;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TransactionService {

    private final List<Transaction> transactions;

    public TransactionService(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public List<Transaction> getAllTransactions(Period period){
        return transactions.stream().filter(txn->
                !txn.getTransactionDate().isBefore(period.getFrom())
                && !txn.getTransactionDate().isAfter(period.getTo()))
                .collect(Collectors.toList());
    }
}
