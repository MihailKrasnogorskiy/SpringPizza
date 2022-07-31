create table if not exists Pizza_Order
(
    id              identity,
    delivery_name   varchar   not null,
    delivery_city   varchar   not null,
    delivery_street varchar   not null,
    delivery_house  varchar   not null,
    delivery_flat   varchar   not null,
    cc_number       varchar   not null,
    cc_expiration   varchar   not null,
    cc_cvv          varchar   not null,
    placed_at       timestamp not null,
    CONSTRAINT pk_order PRIMARY KEY (id)
);

create table if not exists Pizza
(
    id              identity,
    name            varchar   not null,
    pizza_order     bigint    not null,
    pizza_order_key bigint    not null,
    created_at      timestamp not null,
        CONSTRAINT pk_pizza PRIMARY KEY (id)
);

create table if not exists Pizza_Ingredient
(
    ingredient varchar not null,
    pizza      bigint  not null,
    pizza_key  bigint  not null,
    CONSTRAINT pk_ingredient_ref PRIMARY KEY (ingredient, pizza)
);


create table if not exists Ingredient
(
    id   varchar not null,
    name varchar not null,
    type varchar not null,
    CONSTRAINT pk_ingredient PRIMARY KEY (id)
);


alter table Pizza
    add foreign key (pizza_order) references Pizza_Order (id);
alter table Pizza_Ingredient
    add foreign key (ingredient) references Ingredient (id);