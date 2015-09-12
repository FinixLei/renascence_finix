DROP TABLE IF EXISTS `category_first_level`;
CREATE TABLE `category_first_level` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(128) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
DROP TABLE IF EXISTS `category_second_level`;
CREATE TABLE `category_second_level` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(128) NOT NULL,
  `first_level_id` mediumint(8) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
DROP TABLE IF EXISTS `category_third_level`;
CREATE TABLE `category_third_level` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(128) NOT NULL,
  `second_level_id` mediumint(8) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `merchant_id` int(10) unsigned NOT NULL,
  `product_id` int(10) unsigned NOT NULL,
  `type` tinyint(4) NOT NULL COMMENT '1: for sell; 2: for rent',
  `total_count` mediumint(8) unsigned NOT NULL,
  `current_count` mediumint(8) unsigned NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `state` tinyint(4) unsigned NOT NULL COMMENT '0, off shelve; 1, shelve',
  `description` varchar(1024) DEFAULT NULL,
  `thumbnails` varchar(1024) DEFAULT NULL,
  `pictures` varchar(1024) DEFAULT NULL,
  `shelf_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `owner_id` (`merchant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 NOT NULL,
  `description` varchar(1024) CHARACTER SET utf8 DEFAULT NULL,
  `sku_count` tinyint(4) NOT NULL,
  `category_first_level_id` mediumint(8) NOT NULL,
  `category_second_level_id` mediumint(8) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO item (merchant_id, product_id, name, price, shelf_time, total_count, current_count, type, state) 
VALUES (1, 1, 'item_1', 3999, '2015-09-07 13:00:12', 0, 0, 1, 1);
INSERT INTO item (merchant_id, product_id, name, price, shelf_time, total_count, current_count, type, state) 
VALUES (1, 2, 'item_2', 4999, '2015-09-07 14:00:12', 0, 0, 1, 1);
INSERT INTO item (merchant_id, product_id, name, price, shelf_time, total_count, current_count, type, state) 
VALUES (2, 3, 'item_3', 5999, '2015-09-07 15:00:12', 0, 0, 1, 1);

INSERT INTO product (name, category_first_level_id, category_second_level_id, sku_count) VALUES ('Envy 1000', 100, 1001, 10);
INSERT INTO product (name, category_first_level_id, category_second_level_id, sku_count) VALUES ('Envy 2000', 200, 2001, 10);
INSERT INTO product (name, category_first_level_id, category_second_level_id, sku_count) VALUES ('Envy 3000', 200, 2001, 10);

SELECT * FROM product INNER JOIN item
WHERE product.id = item.product_id
AND category_first_level_id = 200 
AND category_second_level_id = 2001
ORDER BY shelf_time DESC;
