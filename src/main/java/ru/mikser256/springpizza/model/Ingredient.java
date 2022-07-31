package ru.mikser256.springpizza.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table
public class Ingredient implements Persistable<String> {
    @Id
    private final String id;
    private final String name;
    private final IngredientType type;

    @Override
    public boolean isNew() {
        return true;
    }
}
