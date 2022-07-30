package ru.mikser256.springpizza.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.mikser256.springpizza.controllers.service.IngredientService;
import ru.mikser256.springpizza.model.Ingredient;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

    private final IngredientService service;

    @Autowired
    public IngredientByIdConverter(IngredientService service) {
        this.service = service;
    }

    @Override
    public Ingredient convert(String id) {
        return service.findById(id).orElse(null);
    }
}
