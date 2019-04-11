-- Order table
CREATE TABLE IF NOT EXISTS `t_order` (
  `id` int NOT NULL AUTO_INCREMENT,
  `userId` int DEFAULT NULL,
  `orderDate` datetime DEFAULT NULL,
  `orderStatus` varchar(10) DEFAULT NULL,
  `amount` decimal(12,2) DEFAULT NULL,
  `userName` varchar(25) NOT NULL,
  `userPhone` varchar(20) DEFAULT NULL,
  `userAddress` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- OrderItem table
CREATE TABLE IF NOT EXISTS `t_order_item` (
  `id` int NOT NULL AUTO_INCREMENT,
  `productId` int DEFAULT NULL,
  `productNum` int DEFAULT NULL,
  `orderId` int DEFAULT NULL,
  `productPrice` decimal(12,2) DEFAULT NULL,
  `productName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- User table
CREATE TABLE IF NOT EXISTS `t_user` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `userName` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL,
  `trueName` varchar(25) NOT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `cteateDate` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Product table
CREATE TABLE IF NOT EXISTS `t_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `productName` varchar(50) DEFAULT NULL,
  `price` decimal(12,2) DEFAULT NULL,
  `status` varchar(2) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `lable` varchar(20) DEFAULT NULL,
  `desctail` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;