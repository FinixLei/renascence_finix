DROP TABLE IF EXISTS `category_first_level`;
CREATE TABLE `category_first_level` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `category_second_level`;
CREATE TABLE `category_second_level` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(128) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `category_third_level`;
CREATE TABLE `category_third_level` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(128) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `merchant_id` int(10) unsigned NOT NULL,
  `product_id` int(10) unsigned NOT NULL,
  `type` tinyint(4) NOT NULL Default 1 COMMENT '1: for sell; 2: for rent',
  `total_count` mediumint(8) unsigned NOT NULL DEFAULT 0,
  `current_count` mediumint(8) unsigned NOT NULL DEFAULT 0,
  `price` decimal(10,2) NOT NULL,
  `state` tinyint(4) unsigned NOT NULL DEFAULT 1 COMMENT '0, off shelve; 1, shelve',
  `description` varchar(1024) DEFAULT NULL,
  `thumbnails` varchar(1024) DEFAULT NULL,
  `pictures` varchar(1024) DEFAULT 'http://',
  `shelf_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `owner_id` (`merchant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `category_1` mediumint(8) NOT NULL,
  `category_2` mediumint(8) NOT NULL,
  `category_3` mediumint(8) DEFAULT NULL,
  `description` varchar(1024) DEFAULT NULL,
  `sku_count` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO item (merchant_id, product_id, price, shelf_time) 
VALUES (1, 1, 3999, '2015-09-07 13:00:12');
INSERT INTO item (merchant_id, product_id, price, shelf_time) 
VALUES (1, 2, 4999, '2015-09-07 14:00:12');
INSERT INTO item (merchant_id, product_id, price, shelf_time) 
VALUES (2, 3, 5999, '2015-09-07 15:00:12');

INSERT INTO product (name, category_1, category_2, sku_count) VALUES ('Envy 1000', '100', '1001', 10);
INSERT INTO product (name, category_1, category_2, sku_count) VALUES ('Envy 2000', '200', '2001', 20);
INSERT INTO product (name, category_1, category_2, sku_count) VALUES ('Envy 3000', '200', '2001', 15);

SELECT * FROM product INNER JOIN item
WHERE product.id = item.product_id
AND category_1 = 200 
AND category_2 = 2001
ORDER BY shelf_time DESC;
