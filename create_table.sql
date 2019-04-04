-- 商品表
CREATE TABLE `t_goods` (
  `Id` varchar(50) NOT NULL,
  `goodsName` varchar(50) DEFAULT NULL,
  `price` decimal(12,2) DEFAULT NULL,
  `status` varchar(2) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `lable` varchar(20) DEFAULT NULL,
  `desctail` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4

-- 订单表
CREATE TABLE `t_order` (
  `Id` varchar(50) NOT NULL,
  `userId` varchar(50) DEFAULT NULL,
  `orderDate` datetime DEFAULT NULL,
  `status` varchar(2) DEFAULT NULL,
  `amount` decimal(12,2) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4

-- 订单详情表
CREATE TABLE `t_order_item` (
  `Id` varchar(50) NOT NULL,
  `goodsId` varchar(50) DEFAULT NULL,
  `goodsNum` int(11) DEFAULT NULL,
  `orderId` varchar(50) DEFAULT NULL,
  `goodsPrice` decimal(12,2) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4