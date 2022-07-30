package ru.mikser256.springpizza.model;

import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class PizzaOrder {
    private Long id;
    private Date placedAt;
    @NotBlank(message = "Введите имя")
    private String deliveryName;
    @NotBlank(message = "Введите название города")
    private String deliveryCity;
    @NotBlank(message = "Введите название улицы")
    private String deliveryStreet;
    @NotBlank(message = "Введите номер дома")
    private String deliveryNumberOfHouse;
    @NotBlank(message = "Введите номер квартиры")
    private String deliveryFlat;
    @CreditCardNumber(message = "Введите корректный номер карты")
    private String ccNumber;
    @Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([2-9][0-9])$", message = "Данные должны быть в формате ММ/ГГ")
    private String ccExpiration;
    @Digits(integer = 3, fraction = 0, message = "Ошибочный CVV")
    private String ccCVV;
    private List<Pizza> pizzas = new ArrayList<>();

    public void addPizza(Pizza pizza) {
        this.pizzas.add(pizza);
    }
}
