package ru.mikser256.springpizza.controllers.service;

import ru.mikser256.springpizza.model.PizzaOrder;

public interface OrderService {

    PizzaOrder save(PizzaOrder pizzaOrder);
}
