package ru.mikser256.springpizza.repository;

import ru.mikser256.springpizza.model.PizzaOrder;

public interface OrderRepository {
    PizzaOrder save(PizzaOrder pizzaOrder);
}
