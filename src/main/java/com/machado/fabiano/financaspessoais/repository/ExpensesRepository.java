package com.machado.fabiano.financaspessoais.repository;

import com.machado.fabiano.financaspessoais.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpensesRepository extends JpaRepository<Expense, Long> {


}
