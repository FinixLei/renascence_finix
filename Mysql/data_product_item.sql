use renascence_finix;

-- Test Data

INSERT INTO item (merchant_id, product_id, name, price, shelf_time, total_count, current_count, type, state) 
VALUES (1, 1, 'item_1', 1000, '2015-08-01 13:00:12', 0, 0, 1, 1);
INSERT INTO item (merchant_id, product_id, name, price, shelf_time, total_count, current_count, type, state) 
VALUES (1, 2, 'item_2', 2000, '2015-08-02 14:00:12', 0, 0, 1, 1);
INSERT INTO item (merchant_id, product_id, name, price, shelf_time, total_count, current_count, type, state) 
VALUES (2, 3, 'item_3', 3000, '2015-08-03 15:00:12', 0, 0, 1, 1);
INSERT INTO item (merchant_id, product_id, name, price, shelf_time, total_count, current_count, type, state) 
VALUES (1, 4, 'item_4', 4000, '2015-08-04 13:00:12', 0, 0, 1, 1);
INSERT INTO item (merchant_id, product_id, name, price, shelf_time, total_count, current_count, type, state) 
VALUES (1, 5, 'item_5', 5000, '2015-08-05 14:00:12', 0, 0, 1, 1);
INSERT INTO item (merchant_id, product_id, name, price, shelf_time, total_count, current_count, type, state) 
VALUES (2, 6, 'item_6', 6000, '2015-08-06 15:00:12', 0, 0, 1, 1);
INSERT INTO item (merchant_id, product_id, name, price, shelf_time, total_count, current_count, type, state) 
VALUES (1, 7, 'item_7', 7000, '2015-08-07 13:00:12', 0, 0, 1, 1);
INSERT INTO item (merchant_id, product_id, name, price, shelf_time, total_count, current_count, type, state) 
VALUES (1, 8, 'item_8', 8000, '2015-08-08 14:00:12', 0, 0, 1, 1);
INSERT INTO item (merchant_id, product_id, name, price, shelf_time, total_count, current_count, type, state) 
VALUES (2, 9, 'item_9', 9000, '2015-08-09 15:00:12', 0, 0, 1, 1);
INSERT INTO item (merchant_id, product_id, name, price, shelf_time, total_count, current_count, type, state) 
VALUES (1, 10, 'item_10', 10000, '2015-08-10 13:00:12', 0, 0, 1, 1);
INSERT INTO item (merchant_id, product_id, name, price, shelf_time, total_count, current_count, type, state) 
VALUES (1, 11, 'item_11', 11000, '2015-08-11 14:00:12', 0, 0, 1, 1);
INSERT INTO item (merchant_id, product_id, name, price, shelf_time, total_count, current_count, type, state) 
VALUES (2, 12, 'item_12', 12000, '2015-08-12 15:00:12', 0, 0, 1, 1);
INSERT INTO item (merchant_id, product_id, name, price, shelf_time, total_count, current_count, type, state) 
VALUES (2, 13, 'item_13', 13000, '2015-08-13 15:00:12', 0, 0, 1, 1);

INSERT INTO item (merchant_id, product_id, name, price, shelf_time, total_count, current_count, type, state) 
VALUES (1, 2, 'item_22', 2000, '2015-08-22 14:00:12', 0, 0, 1, 1);
INSERT INTO item (merchant_id, product_id, name, price, shelf_time, total_count, current_count, type, state) 
VALUES (2, 3, 'item_23', 3000, '2015-08-23 15:00:12', 0, 0, 1, 1);
INSERT INTO item (merchant_id, product_id, name, price, shelf_time, total_count, current_count, type, state) 
VALUES (1, 4, 'item_24', 4000, '2015-08-24 13:00:12', 0, 0, 1, 1);
INSERT INTO item (merchant_id, product_id, name, price, shelf_time, total_count, current_count, type, state) 
VALUES (1, 5, 'item_25', 5000, '2015-08-25 14:00:12', 0, 0, 1, 1);
INSERT INTO item (merchant_id, product_id, name, price, shelf_time, total_count, current_count, type, state) 
VALUES (2, 6, 'item_26', 6000, '2015-08-26 15:00:12', 0, 0, 1, 1);

INSERT INTO product (name, category_first_level_id, category_second_level_id, sku_count) VALUES ('Envy 1000', 100, 1001, 10);  -- product id is 1
INSERT INTO product (name, category_first_level_id, category_second_level_id, sku_count) VALUES ('Envy 2000', 200, 2001, 1);   -- product id is 2
INSERT INTO product (name, category_first_level_id, category_second_level_id, sku_count) VALUES ('Envy 2010', 200, 2001, 2);   -- product id is 3
INSERT INTO product (name, category_first_level_id, category_second_level_id, sku_count) VALUES ('Envy 2020', 200, 2001, 3);   -- product id is 4
INSERT INTO product (name, category_first_level_id, category_second_level_id, sku_count) VALUES ('Envy 2030', 200, 2001, 4);   -- product id is 5
INSERT INTO product (name, category_first_level_id, category_second_level_id, sku_count) VALUES ('Envy 2040', 200, 2001, 5);   -- product id is 6
INSERT INTO product (name, category_first_level_id, category_second_level_id, sku_count) VALUES ('Envy 2050', 200, 2001, 6);   -- product id is 7
INSERT INTO product (name, category_first_level_id, category_second_level_id, sku_count) VALUES ('Envy 2060', 200, 2001, 7);   -- product id is 8
INSERT INTO product (name, category_first_level_id, category_second_level_id, sku_count) VALUES ('Envy 2070', 200, 2001, 8);   -- product id is 9
INSERT INTO product (name, category_first_level_id, category_second_level_id, sku_count) VALUES ('Envy 2080', 200, 2001, 9);   -- product id is 10
INSERT INTO product (name, category_first_level_id, category_second_level_id, sku_count) VALUES ('Envy 2090', 200, 2001, 10);  -- product id is 11
INSERT INTO product (name, category_first_level_id, category_second_level_id, sku_count) VALUES ('Envy 2100', 200, 2001, 11);  -- product id is 12
INSERT INTO product (name, category_first_level_id, category_second_level_id, sku_count) VALUES ('Envy 2110', 200, 2001, 12);  -- product id is 13

SELECT * FROM product INNER JOIN item
WHERE product.id = item.product_id
AND category_first_level_id = 200 
AND category_second_level_id = 2001
ORDER BY price ASC;
