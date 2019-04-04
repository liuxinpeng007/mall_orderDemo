package com.mall.order.service.impl;

import com.mall.order.entity.Goods;
import com.mall.order.entity.OrderGoods;

import java.util.List;

public interface IOrderService {

    /**
     * 根据订单ID查询订单信息
     *
     * @param id 订单ID
     * @return 订单信息
     */
    OrderGoods getOrderById(String id);

    /**
     * 根据用户ID查询订单信息
     *
     * @param userId 用户ID
     * @return 订单
     */
    List<OrderGoods> getOrderByUserId(String userId);

    /**
     * 添加订单
     *
     * @param goods 商品信息
     */
    boolean addOrder(List<Goods> goods) throws Exception;
}
