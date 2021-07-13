package com.hanusha.test.service;

import com.hanusha.test.model.Customer;
import com.hanusha.test.model.Period;
import com.hanusha.test.model.Reward;
import com.hanusha.test.model.Transaction;

import java.util.List;

public final class RewardCalculator {

    private RewardCalculator(){

    }

    public static Reward calculateReward(Customer customer, List<Transaction> transactions, Period period) {
        return new Reward(
                customer,
                transactions.stream().map(RewardCalculator::getEarnedPoints).reduce(0, Integer::sum),
                period
        );
    }

    private static int getEarnedPoints(Transaction transaction) {
        int pointEarned = 0;
        if (transaction.getAmount() > 100) {
            int amount = transaction.getAmount();
            int diff = amount - 100;
            pointEarned = diff * 2;
            int diff50 = amount - 50;
            int addPt = diff50 % 50;
            pointEarned += addPt;
        }
        return pointEarned;
    }


}
