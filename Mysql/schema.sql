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
