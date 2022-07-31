package ru.mikser256.springpizza.model;

import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table
public class PizzaIngredient {

    private final String ingredient;

}