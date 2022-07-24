package ru.mikser256.springpizza.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.mikser256.springpizza.model.Ingredient;
import ru.mikser256.springpizza.model.IngredientType;
import ru.mikser256.springpizza.model.Pizza;
import ru.mikser256.springpizza.model.PizzaOrder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("pizzaOrder")
public class DesignPizzaController {
    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("ROME", "Rome Pizza", IngredientType.WRAP),
                new Ingredient("CLSC", "Classic Pizza", IngredientType.WRAP),
                new Ingredient("SALM", "Salami", IngredientType.PROTEIN),
                new Ingredient("BACN", "Bacon", IngredientType.PROTEIN),
                new Ingredient("TMTO", "Rings Tomatoes", IngredientType.VEGGIES),
                new Ingredient("SALD", "Salad", IngredientType.VEGGIES),
                new Ingredient("CHED", "Cheddar", IngredientType.CHEESE),
                new Ingredient("LMBR", "Lamber", IngredientType.CHEESE),
                new Ingredient("SLSA", "Salsa", IngredientType.SAUCE),
                new Ingredient("SRCR", "Sour Cream", IngredientType.SAUCE)
        );
        IngredientType[] types = IngredientType.values();
        for (IngredientType type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }
    }

    @ModelAttribute(name = "pizzaOrder")
    public PizzaOrder order() {
        return new PizzaOrder();
    }

    @ModelAttribute(name = "pizza")
    public Pizza pizza() {
        return new Pizza();
    }

    @GetMapping
    public String showDesignForm() {
        return "design";
    }

    @PostMapping
    public String processPizza(Pizza pizza,
                              @ModelAttribute PizzaOrder pizzaOrder) {
        pizzaOrder.addPizza(pizza);
        log.info("Processing pizza: {}", pizza);
        return "redirect:/orders/current";
    }

    private Iterable<Ingredient> filterByType(
            List<Ingredient> ingredients, IngredientType type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }
}