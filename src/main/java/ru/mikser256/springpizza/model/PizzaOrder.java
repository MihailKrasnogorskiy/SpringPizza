package ru.mikser256.springpizza.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PizzaOrder {
    private String deliveryName;
    private String deliveryStreet;
    private String deliveryCity;
    private String deliveryState;
    private String deliveryZip;
    private String ccNumber;
    private String ccExpiration;
    private String ccCVV;
    private List<Pizza> tacos = new ArrayList<>();

    public void addPizza(Pizza pizza) {
        this.tacos.add(pizza);
    }
}
