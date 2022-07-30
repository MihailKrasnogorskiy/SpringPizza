package ru.mikser256.springpizza.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
public class Pizza {
    private Long id;
    private Date createdAt;
    @NotNull
    @Size(min = 5, message = "Придумайте название не меньше 5 символов")
    private String name;
    @NotNull
    @Size(min = 1, message = "Добавьте хотя бы один ингридиент")
    private List<Ingredient> ingredients;
}
