package ru.mikser256.springpizza.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.mikser256.springpizza.model.Ingredient;
import ru.mikser256.springpizza.model.IngredientType;

import java.util.HashMap;
import java.util.Map;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

    private Map<String, Ingredient> ingredientMap = new HashMap<>();

    public IngredientByIdConverter() {
        ingredientMap.put("ROME",
                new Ingredient("ROME", "Римская пицца", IngredientType.WRAP));
        ingredientMap.put("CLSC",
                new Ingredient("CLSC", "Классическая пицца", IngredientType.WRAP));
        ingredientMap.put("SALM",
                new Ingredient("SALM", "Салями", IngredientType.PROTEIN));
        ingredientMap.put("BACN",
                new Ingredient("BACN", "Бекон", IngredientType.PROTEIN));
        ingredientMap.put("TMTO",
                new Ingredient("TMTO", "Помидоры", IngredientType.VEGGIES));
        ingredientMap.put("SALD",
                new Ingredient("SALD", "Салат", IngredientType.VEGGIES));
        ingredientMap.put("CHED",
                new Ingredient("CHED", "Чеддер", IngredientType.CHEESE));
        ingredientMap.put("LMBR",
                new Ingredient("LMBR", "Ламбер", IngredientType.CHEESE));
        ingredientMap.put("SLSA",
                new Ingredient("SLSA", "Сальса", IngredientType.SAUCE));
        ingredientMap.put("SRCR",
                new Ingredient("SRCR", "Кисло-сладкий соус", IngredientType.SAUCE));
    }

    @Override
    public Ingredient convert(String id) {
        return ingredientMap.get(id);
    }
}
