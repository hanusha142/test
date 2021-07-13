package com.hanusha.test.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@AllArgsConstructor
@Data
public class Period {
    private LocalDate from;
    private LocalDate to;

    public static final Period of(LocalDate from, LocalDate to) {
        return new Period(from, to);
    }
}
