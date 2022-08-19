package com.machado.fabiano.financaspessoais.dto;

import com.machado.fabiano.financaspessoais.model.Expense;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ExpensesDto {

    private String description;
    private BigDecimal value;
    private LocalDate date;

    public String getDescription() {
        return description;
    }

    public BigDecimal getValue() {
        return value;
    }

    public LocalDate getDate() {
        return date;
    }

    public ExpensesDto(Expense expense) {
        this.description = expense.getDescription();
        this.value = expense.getValue();
        this.date = expense.getDate();
    }

    public static List<ExpensesDto> convert(List<Expense> expenses) {
        List<ExpensesDto> dtos = new ArrayList<>();

        for (Expense expense : expenses) {
            ExpensesDto dto = new ExpensesDto(expense);
            dtos.add(dto);
        }

        return dtos;
    }
}
