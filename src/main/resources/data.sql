INSERT INTO CATEGORY(name) VALUES('PILSEN');
INSERT INTO CATEGORY(name) VALUES('WITBIER');
INSERT INTO CATEGORY(name) VALUES('WEISS');
INSERT INTO CATEGORY(name) VALUES('STOUT');
INSERT INTO CATEGORY(name) VALUES('AMERICAN LAGER');

INSERT INTO INGREDIENT(name) VALUES ('LÚPULO');
INSERT INTO INGREDIENT(name) VALUES ('MALTE');
INSERT INTO INGREDIENT(name) VALUES ('LEVEDURAS');
INSERT INTO INGREDIENT(name) VALUES ('ERVA-MATE');
INSERT INTO INGREDIENT(name) VALUES ('BAUNILHA');
INSERT INTO INGREDIENT(name) VALUES ('FRUTAS VERMELHAS');

INSERT INTO BEER (alcohol_content, name, price, category_id) VALUES (7.5, 'CERVEJA 1', 10.5, 5);
INSERT INTO BEER (alcohol_content, name, price, category_id) VALUES (5, 'CERVEJA 2', 12, 2);
INSERT INTO BEER (alcohol_content, name, price, category_id) VALUES (4.8, 'CERVEJA 3', 8.99, 1);

INSERT INTO BEER_INGREDIENTS (BEERS_ID, INGREDIENTS_ID) VALUES (1,1);
INSERT INTO BEER_INGREDIENTS (BEERS_ID, INGREDIENTS_ID) VALUES (1,6);
INSERT INTO BEER_INGREDIENTS (BEERS_ID, INGREDIENTS_ID) VALUES (1,2);
INSERT INTO BEER_INGREDIENTS (BEERS_ID, INGREDIENTS_ID) VALUES (2,2);
INSERT INTO BEER_INGREDIENTS (BEERS_ID, INGREDIENTS_ID) VALUES (2,5);
INSERT INTO BEER_INGREDIENTS (BEERS_ID, INGREDIENTS_ID) VALUES (3,2);
INSERT INTO BEER_INGREDIENTS (BEERS_ID, INGREDIENTS_ID) VALUES (3,4);
INSERT INTO BEER_INGREDIENTS (BEERS_ID, INGREDIENTS_ID) VALUES (3,3);


