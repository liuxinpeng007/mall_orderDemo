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
     * Query the orders information by map
     *
     * @param queryMap query map
     * @return orders information
     */
    List<Order> queryOrders(Map queryMap) throws Exception;

    /**
     * create order
     *
     * @param order order
     */
    boolean addOrder(Order order) throws Exception;

    /**
     * Delete order
     *
     * @param id order ID
     */
    boolean deleteOrder(Integer id) throws Exception;
}
