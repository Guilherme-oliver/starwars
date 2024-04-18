INSERT INTO tb_planet (name, climate, terrain) VALUES ('Tatooine', 'Arid', 'desert');
INSERT INTO tb_planet (name, climate, terrain) VALUES ('Alderaan', 'Temperate', 'Grasslands, mountains');
INSERT INTO tb_planet (name, climate, terrain) VALUES ('Yavin IV', 'Temperate, tropical', 'Jungle, rainforests');
INSERT INTO tb_planet (name, climate, terrain) VALUES ('Naboo', 'Temperate', 'Grassy hills, forest, mountains');

INSERT INTO tb_film (title, director, producer) VALUES ('A New Hope', 'George Lucas', 'Gary Kurtz, Rick McCallum');
INSERT INTO tb_film (title, director, producer) VALUES ('Attack Of The Clones', 'George Lucas', 'Rick McCallum');
INSERT INTO tb_film (title, director, producer) VALUES ('Return of the jedi', 'Richard Marquand', 'George Lucas, Howard G. Kazanjian, Rick McCallum');
INSERT INTO tb_film (title, director, producer) VALUES ('The Phantom Menace', 'George Lucas', 'Rick McCallum');

INSERT INTO tb_planet_film (planet_id, film_id) VALUES (1, 1);
INSERT INTO tb_planet_film (planet_id, film_id) VALUES (1, 3);
INSERT INTO tb_planet_film (planet_id, film_id) VALUES (2, 1);
INSERT INTO tb_planet_film (planet_id, film_id) VALUES (2, 4);
INSERT INTO tb_planet_film (planet_id, film_id) VALUES (3, 2);
INSERT INTO tb_planet_film (planet_id, film_id) VALUES (3, 3);
INSERT INTO tb_planet_film (planet_id, film_id) VALUES (4, 2);
INSERT INTO tb_planet_film (planet_id, film_id) VALUES (4, 4);