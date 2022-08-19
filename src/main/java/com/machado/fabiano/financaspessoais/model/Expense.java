package com.machado.fabiano.financaspessoais.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "expenses")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private String category;
    private BigDecimal value;
    private LocalDate date;

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public BigDecimal getValue() {
        return value;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDescription(String descricao) {
        this.description = descricao;
    }

    public void setCategory(String categoria) {
        this.category = categoria;
    }

    public void setValue(BigDecimal valor) {
        this.value = valor;
    }

    public void setDate(LocalDate data) {
        this.date = data;
    }
}
