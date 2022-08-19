package com.machado.fabiano.financaspessoais.form;

import com.machado.fabiano.financaspessoais.model.Expense;
import com.machado.fabiano.financaspessoais.repository.ExpensesRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ExpenseForm {

    @NotNull @NotEmpty
    private String description;
    @NotNull @NotEmpty
    private String category;
    @NotNull @NotEmpty
    private String value;
    @NotNull @NotEmpty
    private String date;

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public String getValue() {
        return value;
    }

    public String getDate() {
        return date;
    }

    public Expense convert() {
        Expense expense = new Expense();
        return setExpense(expense);
    }

    public Expense update(Long id, ExpensesRepository expensesRepository) {
        Expense expense = expensesRepository.getReferenceById(id);
        return setExpense(expense);
    }

    private Expense setExpense(Expense expense) {
        expense.setDescription(description);
        expense.setCategory(category);
        expense.setValue(new BigDecimal(value));
        expense.setDate(LocalDate.parse(date, formatter));

        return expense;
    }
}