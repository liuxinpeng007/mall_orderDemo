-- order table
CREATE TABLE IF NOT EXISTS `t_order` (
  `id` int NOT NULL AUTO_INCREMENT,
  `userId` int DEFAULT NULL,
  `orderDate` datetime DEFAULT NULL,
  `status` varchar(2) DEFAULT NULL,
  `amount` decimal(12,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- order item table
CREATE TABLE IF NOT EXISTS `t_order_item` (
  `id` int NOT NULL AUTO_INCREMENT,
  `goodId` int DEFAULT NULL,
  `goodNum` int DEFAULT NULL,
  `orderId` int DEFAULT NULL,
  `goodPrice` decimal(12,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;