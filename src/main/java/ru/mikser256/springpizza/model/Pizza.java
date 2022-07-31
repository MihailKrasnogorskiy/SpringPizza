package ru.mikser256.springpizza.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Table()
@EqualsAndHashCode(exclude = "createdAt")
public class Pizza {
    @Id
    private Long id;
    private Date createdAt = new Date();
    @NotNull
    @Size(min = 5, message = "Придумайте название не меньше 5 символов")
    private String name;
    @NotNull
    @Size(min = 1, message = "Добавьте хотя бы один ингридиент")
    private List<PizzaIngredient> ingredients = new ArrayList<>();

    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(new PizzaIngredient(ingredient.getId()));
    }
}
