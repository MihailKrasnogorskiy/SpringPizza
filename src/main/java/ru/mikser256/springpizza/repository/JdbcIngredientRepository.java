package ru.mikser256.springpizza.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.mikser256.springpizza.model.Ingredient;
import ru.mikser256.springpizza.model.IngredientType;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class JdbcIngredientRepository implements IngredientRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcIngredientRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Ingredient> findAll() {
        String sqlQery = "select id, name, ingredient_type from ingredient";
        return jdbcTemplate.query(sqlQery, this::mapRowToIngredient);
    }

    private Ingredient mapRowToIngredient(ResultSet rs, int rowNum) throws SQLException {
        return new Ingredient(
                rs.getString("id"),
                rs.getString("name"),
                IngredientType.valueOf(rs.getString("ingredient_type"))
        );
    }

    @Override
    public Optional<Ingredient> findById(String id) {
        String sqlQery = "SELECT id, name, ingredient_type FROM ingredient WHERE id = ?";
        List<Ingredient> ingredients = jdbcTemplate.query(sqlQery, this::mapRowToIngredient, id);
        return ingredients.isEmpty() ? Optional.empty() : Optional.of(ingredients.get(0));
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        jdbcTemplate.update(
                "INSERT INTO ingredient (id, name, ingredient_type) values (?, ?, ?)",
                ingredient.getId(),
                ingredient.getName(),
                ingredient.getType().toString());
        return ingredient;
    }
}
