package com.machado.fabiano.financaspessoais.controller;

import com.machado.fabiano.financaspessoais.dto.ExpensesDto;
import com.machado.fabiano.financaspessoais.form.ExpenseForm;
import com.machado.fabiano.financaspessoais.model.Expense;
import com.machado.fabiano.financaspessoais.repository.ExpensesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpensesController {

    @Autowired
    private ExpensesRepository expensesRepository;

    @GetMapping
    public List<ExpensesDto> list() {
        List<Expense> expenses = expensesRepository.findAll();

        return ExpensesDto.convert(expenses);
    }

    @GetMapping("/{id}")
    public ExpensesDto findSingleExpense(@PathVariable Long id) {

        Expense expense = expensesRepository.getReferenceById(id);
        return new ExpensesDto(expense);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remove(@PathVariable Long id) {

        expensesRepository.deleteById(id);

        return ResponseEntity.ok().build();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ExpensesDto> create(@RequestBody @Valid ExpenseForm form, UriComponentsBuilder uriBuilder) {  //@Valid
        Expense expense = form.convert();
        expensesRepository.save(expense);

        URI uri = uriBuilder.path("/expense/{id}").buildAndExpand(expense.getId()).toUri();
        return ResponseEntity.created(uri).body(new ExpensesDto(expense));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ExpensesDto> update(@PathVariable Long id, @RequestBody @Valid ExpenseForm form) {
        Expense expense = form.update(id, expensesRepository);

        return ResponseEntity.ok(new ExpensesDto(expense));
    }
}