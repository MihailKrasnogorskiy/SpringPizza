package ru.mikser256.springpizza.controllers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mikser256.springpizza.model.PizzaOrder;
import ru.mikser256.springpizza.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository repository;

    @Autowired
    public OrderServiceImpl(OrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public PizzaOrder save(PizzaOrder pizzaOrder) {
        return repository.save(pizzaOrder);
    }
}
