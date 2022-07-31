package ru.mikser256.springpizza.repository;

import org.springframework.data.repository.CrudRepository;
import ru.mikser256.springpizza.model.PizzaOrder;

public interface OrderRepository extends CrudRepository<PizzaOrder, Long> {
}
