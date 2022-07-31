package ru.mikser256.springpizza.controllers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mikser256.springpizza.repository.IngredientRepository;
import ru.mikser256.springpizza.model.Ingredient;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientServiceImpl implements IngredientService {
    private final IngredientRepository repository;

    @Autowired
    public IngredientServiceImpl(IngredientRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Ingredient> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Ingredient> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        return repository.save(ingredient);
    }
}