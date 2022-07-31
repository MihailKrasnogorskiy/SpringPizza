package ru.mikser256.springpizza;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.mikser256.springpizza.model.Ingredient;
import ru.mikser256.springpizza.model.IngredientType;
import ru.mikser256.springpizza.repository.IngredientRepository;

@SpringBootApplication
public class SpringPizzaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringPizzaApplication.class, args);
    }

    @Bean
    public CommandLineRunner dataLoader(IngredientRepository repository) {
        return args -> {
            repository.deleteAll();
            repository.save(new Ingredient("ROME", "Римская пицца", IngredientType.WRAP));
            repository.save(new Ingredient("CLSC", "Классическая пицца", IngredientType.WRAP));
            repository.save(new Ingredient("SALM", "Салями", IngredientType.PROTEIN));
            repository.save(new Ingredient("BAСN", "Бекон", IngredientType.PROTEIN));
            repository.save(new Ingredient("TMTO", "Помидор", IngredientType.VEGGIES));
            repository.save(new Ingredient("SALD", "Салат", IngredientType.VEGGIES));
            repository.save(new Ingredient("CHED", "Чеддер", IngredientType.CHEESE));
            repository.save(new Ingredient("LMBR", "Ламбер", IngredientType.CHEESE));
            repository.save(new Ingredient("SLSA", "Сальса", IngredientType.SAUCE));
            repository.save(new Ingredient("SRCR", "Кисло-сладкий", IngredientType.SAUCE));
        };
    }

}
