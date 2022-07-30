package ru.mikser256.springpizza.repository;

import org.springframework.asm.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.mikser256.springpizza.model.Ingredient;
import ru.mikser256.springpizza.model.Pizza;
import ru.mikser256.springpizza.model.PizzaOrder;

import java.sql.Types;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public class OrderRepositoryImpl implements OrderRepository {

    private final JdbcOperations jdbcOperations;

    @Autowired
    public OrderRepositoryImpl(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public PizzaOrder save(PizzaOrder pizzaOrder) {
        PreparedStatementCreatorFactory pscf = new PreparedStatementCreatorFactory("INSERT INTO pizza_order"
                + "(delivery_name, delivery_street, delivery_city, "
                + "delivery_house, delivery_flat, cc_number, "
                + "cc_expiration, cc_cvv, placed_at) "
                + "values (?,?,?,?,?,?,?,?,?)",
                Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
                Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
                Types.VARCHAR, Types.VARCHAR, Types.TIMESTAMP
        );
        pscf.setReturnGeneratedKeys(true);
        pizzaOrder.setPlacedAt(new Date());
        PreparedStatementCreator psc =
                pscf.newPreparedStatementCreator(
                        Arrays.asList(
                                pizzaOrder.getDeliveryName(),
                                pizzaOrder.getDeliveryCity(),
                                pizzaOrder.getDeliveryStreet(),
                                pizzaOrder.getDeliveryNumberOfHouse(),
                                pizzaOrder.getDeliveryFlat(),
                                pizzaOrder.getCcNumber(),
                                pizzaOrder.getCcExpiration(),
                                pizzaOrder.getCcCVV(),
                                pizzaOrder.getPlacedAt()));

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcOperations.update(psc, keyHolder);
        long orderId = keyHolder.getKey().longValue();
        pizzaOrder.setId(orderId);

        for (Pizza pizza : pizzaOrder.getPizzas()) {
            savePizza(orderId, pizza);
        }
        return pizzaOrder;
    }

    private long savePizza(long orderId, Pizza pizza) {

            pizza.setCreatedAt(new Date());
            PreparedStatementCreatorFactory pscf =
                    new PreparedStatementCreatorFactory(
                            "INSERT INTO pizza"
                                    + "(name,  order_ID, created_at) "
                                    + "values (?, ?, ?)",
                            Types.VARCHAR, Type.LONG, Types.TIMESTAMP
                    );
            pscf.setReturnGeneratedKeys(true);
            PreparedStatementCreator psc =
                    pscf.newPreparedStatementCreator(
                            Arrays.asList(
                                    pizza.getName(),
                                    orderId,
                                    pizza.getCreatedAt()));
            GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcOperations.update(psc, keyHolder);
            long pizzaId = keyHolder.getKey().longValue();
            pizza.setId(pizzaId);
            savePizzaIngredients(pizzaId, pizza.getIngredients());
            return pizzaId;
    }

    private void savePizzaIngredients(long pizzaId, List<Ingredient> ingredients) {
        for(Ingredient ingredient: ingredients){
        jdbcOperations.update(
                "INSERT INTO pizza_ingredients (pizza_id, ingredient_id) "
                        + "values (?, ?)",
                pizzaId, ingredient.getId());
        }
    }
}
