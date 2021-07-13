package com.hanusha.test;

import com.hanusha.test.config.DataGenerator;
import com.hanusha.test.model.AccruedPeriodReward;
import com.hanusha.test.model.Period;
import com.hanusha.test.service.PointsCalculationService;
import com.hanusha.test.service.TransactionService;

import java.time.LocalDate;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Period> periods = Set.of(
                Period.of(LocalDate.now().minusMonths(3), LocalDate.now().minusMonths(2)),
                Period.of(LocalDate.now().minusMonths(2).plusDays(1), LocalDate.now().minusMonths(1)),
                Period.of(LocalDate.now().minusMonths(1).plusDays(1), LocalDate.now())
        );

        DataGenerator dataGenerator = DataGenerator.getInstance();

        PointsCalculationService pointsCalculationService =
                new PointsCalculationService(new TransactionService(dataGenerator.getTransactions()));
        Set<AccruedPeriodReward> accuredPointsFor = pointsCalculationService.getAccuredPointsFor(periods);

        accuredPointsFor.forEach(AccruedPeriodReward::printDetails);
    }
}
