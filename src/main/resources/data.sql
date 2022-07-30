DELETE FROM pizza;
DELETE FROM pizza_order;
DELETE FROM pizza_ingredients;
DELETE FROM ingredient;

INSERT INTO ingredient (id, name, ingredient_type)
VALUES ('ROME', 'Римская пицца', 'WRAP');
INSERT INTO ingredient (id, name, ingredient_type)
VALUES ('CLSC', 'Классическая пицца', 'WRAP');
INSERT INTO ingredient (id, name, ingredient_type)
VALUES ('SALM', 'Салями', 'PROTEIN');
INSERT INTO ingredient (id, name, ingredient_type)
VALUES ('BAСN', 'Бекон', 'PROTEIN');
INSERT INTO ingredient (id, name, ingredient_type)
VALUES ('TMTO', 'Помидор', 'VEGGIES');
INSERT INTO ingredient (id, name, ingredient_type)
VALUES ('SALD', 'Салат', 'VEGGIES');
INSERT INTO ingredient (id, name, ingredient_type)
VALUES ('CHED', 'Чеддер', 'CHEESE');
INSERT INTO ingredient (id, name, ingredient_type)
VALUES ('LMBR', 'Ламбер', 'CHEESE');
INSERT INTO ingredient (id, name, ingredient_type)
VALUES ('SLSA', 'Сальса', 'SAUCE');
INSERT INTO ingredient (id, name, ingredient_type)
VALUES ('SRCR', 'Кисло-сладкий', 'SAUCE');