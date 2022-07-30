CREATE TABLE IF NOT EXISTS pizza_order
(
    id              identity,
    delivery_name   varchar   NOT NULL,
    delivery_city   varchar   NOT NULL,
    delivery_street varchar   NOT NULL,
    delivery_house  varchar   NOT NULL,
    delivery_flat   varchar   NOT NULL,
    cc_number       varchar   NOT NULL,
    cc_expiration   varchar   NOT NULL,
    cc_cvv          varchar   NOT NULL,
    placed_at       timestamp NOT NULL,
    CONSTRAINT pk_pizza_order PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS pizza
(
    id         identity,
    name       varchar   NOT NULL,
    order_id   bigint    NOT NULL,
    created_at timestamp NOT NULL,
    CONSTRAINT pk_pizza PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS ingredient
(
    id              varchar NOT NULL,
    name            varchar NOT NULL,
    ingredient_type varchar NOT NULL,
    CONSTRAINT pk_ingredient PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS pizza_ingredients
(
    pizza_id      bigint NOT NULL,
    ingredient_id varchar    NOT NULL,
    CONSTRAINT pk_pizza_ingredients PRIMARY KEY (pizza_id, ingredient_id)
);

ALTER TABLE pizza
    ADD CONSTRAINT IF NOT EXISTS fk_pizza_order_id FOREIGN KEY (order_id)
        REFERENCES pizza_order (id) ON DELETE CASCADE;

ALTER TABLE pizza_ingredients
    ADD CONSTRAINT IF NOT EXISTS fk_pizza_ingredients_pizza_id FOREIGN KEY (pizza_id)
        REFERENCES pizza (id) ON DELETE CASCADE;

ALTER TABLE pizza_ingredients
    ADD CONSTRAINT IF NOT EXISTS fk_pizza_ingredients_ingredient_id FOREIGN KEY (ingredient_id)
        REFERENCES ingredient (id) ON DELETE CASCADE;