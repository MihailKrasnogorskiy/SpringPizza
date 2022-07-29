package ru.mikser256.springpizza.model;

import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

@Data
public class PizzaOrder {
    @NotBlank (message = "Введите имя")
    private String deliveryName;
    @NotBlank (message = "Введите название города")
    private String deliveryCity;
    @NotBlank (message = "Введите название улицы")
    private String deliveryStreet;
    @NotBlank (message = "Введите номер дома")
    private String deliveryState;
    @NotBlank (message = "Введите номер квартиры")
    @Min(1)
    private String deliveryFlat;
    @CreditCardNumber(message="Введите корректный номер карты")
    private String ccNumber;
    @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([2-9][0-9])$", message="Данные должны быть в формате ММ/ГГ")
    private String ccExpiration;
    @Digits(integer=3, fraction=0, message="Ошибочный CVV")
    private String ccCVV;
    private List<Pizza> pizzas = new ArrayList<>();

    public void addPizza(Pizza pizza) {
        this.pizzas.add(pizza);
    }
}
