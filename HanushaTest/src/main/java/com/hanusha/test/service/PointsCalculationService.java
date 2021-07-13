package com.hanusha.test.service;

import com.hanusha.test.model.AccruedPeriodReward;
import com.hanusha.test.model.Customer;
import com.hanusha.test.model.Period;
import com.hanusha.test.model.Transaction;

import java.util.*;
import java.util.stream.Collectors;

public class PointsCalculationService {

    private final TransactionService transactionService;

    public PointsCalculationService(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    public Set<AccruedPeriodReward> getAccuredPointsFor(Set<Period> periods){
        final Map<Customer, AccruedPeriodReward> rewardMap = new HashMap<>();

        periods.forEach(period -> {
            List<Transaction> allTransactions = transactionService.getAllTransactions(period);
            Map<Customer, List<Transaction>> txnByCustomer = allTransactions.stream().collect(Collectors.groupingBy(Transaction::getCustomer));
            txnByCustomer.forEach((customer, txns) -> {
                rewardMap.putIfAbsent(customer, new AccruedPeriodReward(customer, new HashMap<>()));
                rewardMap.get(customer).getMonthlyReward().put(period, RewardCalculator.calculateReward(customer,txns, period));
            });
        });
        return new HashSet<>(rewardMap.values());
    }
}
