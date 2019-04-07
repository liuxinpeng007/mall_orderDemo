package com.mall.order.service;

import com.mall.order.entity.Order;

import java.util.List;
import java.util.Map;

public interface IOrderService {

    /**
     * Query the order information by order ID
     *
     * @param id order ID
     * @return order information
     */
    Order getOrderById(int id) throws Exception;

    /**
     * Query the order information by map
     *
     * @param queryMap query map
     * @return order information
     */
    List<Order> queryOrderByMap(Map queryMap) throws Exception;

    /**
     * create order
     *
     * @param order order
     */
    boolean addOrder(Order order) throws Exception;
}
