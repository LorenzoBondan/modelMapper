INSERT INTO tb_brand (name) VALUES ('Ferrari');
INSERT INTO tb_brand (name) VALUES ('Mercedes');

INSERT INTO tb_driver (name, age) VALUES ('Driver 1', 25);
INSERT INTO tb_driver (name, age) VALUES ('Driver 2', 30);

INSERT INTO tb_car (name, car_Year, brand_id, driver_id) VALUES ('Ferrari 123', 2000, 1, 1);
INSERT INTO tb_car (name, car_Year, brand_id, driver_id) VALUES ('Mercedes 999', 2015, 2, 1);
INSERT INTO tb_car (name, car_Year, brand_id, driver_id) VALUES ('Gol', 1999, null, 2);

