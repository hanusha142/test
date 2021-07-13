package com.hanusha.test.config;


import com.hanusha.test.model.Customer;
import com.hanusha.test.model.Transaction;
import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class DataGenerator {

    @Getter
    private final List<Transaction> transactions = new ArrayList<>();
    @Getter
    private final Set<Customer> customers = new HashSet<>();

    private static final LocalDate today = LocalDate.now();
    private static final DataGenerator dataGen = new DataGenerator();

    private DataGenerator() {
        Customer john = new Customer("John Doe");
        Customer will = new Customer("Will Smith");
        Customer tom = new Customer("Tom Cruise");
        customers.add(john);
        customers.add(will);
        customers.add(tom);

        transactions.add(new Transaction(john, 120, today));
        transactions.add(new Transaction(john, 100, today.minusDays(1)));
        transactions.add(new Transaction(john, 300, today.minusDays(1)));
        transactions.add(new Transaction(john, 200, today.minusMonths(1)));
        transactions.add(new Transaction(john, 200, today.minusMonths(1)));

        transactions.add(new Transaction(will, 150, today));
        transactions.add(new Transaction(will, 110, today.plusDays(1)));


        transactions.add(new Transaction(tom, 100, today.minusDays(1)));
        transactions.add(new Transaction(tom, 135, today.minusMonths(1)));
        transactions.add(new Transaction(tom, 500, today.minusMonths(1)));
    }

    public static DataGenerator getInstance() {
        return dataGen;
    }
}
