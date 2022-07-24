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
                new Ingredient("ROME", "Rome Pizza", IngredientType.WRAP));
        ingredientMap.put("CLSC",
                new Ingredient("CLSC", "Classic Pizza", IngredientType.WRAP));
        ingredientMap.put("SALM",
                new Ingredient("SALM", "Salami", IngredientType.PROTEIN));
        ingredientMap.put("BACN",
                new Ingredient("BACN", "Bacon", IngredientType.PROTEIN));
        ingredientMap.put("TMTO",
                new Ingredient("TMTO", "Rings Tomatoes", IngredientType.VEGGIES));
        ingredientMap.put("SALD",
                new Ingredient("SALD", "Salad", IngredientType.VEGGIES));
        ingredientMap.put("CHED",
                new Ingredient("CHED", "Cheddar", IngredientType.CHEESE));
        ingredientMap.put("LMBR",
                new Ingredient("LMBR", "Lamber", IngredientType.CHEESE));
        ingredientMap.put("SLSA",
                new Ingredient("SLSA", "Salsa", IngredientType.SAUCE));
        ingredientMap.put("SRCR",
                new Ingredient("SRCR", "Sour Cream", IngredientType.SAUCE));
    }

    @Override
    public Ingredient convert(String id) {
        return ingredientMap.get(id);
    }
}
