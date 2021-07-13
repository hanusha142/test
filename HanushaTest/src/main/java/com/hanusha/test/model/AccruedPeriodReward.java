package com.hanusha.test.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class AccruedPeriodReward {
    private Customer customer;
    private Map<Period, Reward> monthlyReward;

    public void printDetails(){
        System.out.println("-------------------------\n" + toString());
    }

    public int getTotal(){
        return monthlyReward.values().stream().map(Reward::getRewardPoints).reduce(0, Integer::sum);
    }
    public String toString() {
        StringBuilder builder = new StringBuilder("Customer : " + customer.getName());
        String earnedInfo = monthlyReward.entrySet().stream()
                .map(e->"\nEarned "+ e.getValue().getRewardPoints() + " in period " + e.getKey().getFrom()+" - "+ e.getKey().getTo())
                .reduce("", String::concat);
        builder.append(earnedInfo).append(" \nTotal : " +  getTotal());
        return builder.toString();
    }

}
