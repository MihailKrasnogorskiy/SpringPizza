package ru.mikser256.springpizza.repository;

import org.springframework.data.repository.CrudRepository;
import ru.mikser256.springpizza.model.Ingredient;

import java.util.List;
import java.util.Optional;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {
    List<Ingredient> findAll();

    Optional<Ingredient> findById(String id);

    Ingredient save(Ingredient ingredient);
}
