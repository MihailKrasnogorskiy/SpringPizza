package ru.mikser256.springpizza.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import ru.mikser256.springpizza.model.PizzaOrder;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("pizzaOrder")
public class OrderController {

    @GetMapping("/current")
    public String orderFrom() {
        return "orderFrom";
    }

    @PostMapping
    public String processOrder(@Valid PizzaOrder order, Errors errors, SessionStatus sessionStatus) {
        if(errors.hasErrors()){
            return "orderFrom";
        }
        log.info("Заказ создан: {}", order);
        sessionStatus.setComplete();
        return "redirect:/";
    }
}
