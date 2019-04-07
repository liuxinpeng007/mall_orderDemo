package com.mall.order.service.impl;

import com.mall.order.entity.Order;
import com.mall.order.entity.OrderItem;
import com.mall.order.mapper.OrderItemMapper;
import com.mall.order.mapper.OrderMapper;
import com.mall.order.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Order Service
 *
 * @author liuxinpeng
 * @data 2019/04/03
 */
@Service("orderService")
public class OrderServiceImpl implements IOrderService {


    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderItemMapper orderItemMapper;

    /**
     * Query the order information by order ID
     *
     * @param id order ID
     * @return order information
     */
    @Override
    public Order getOrderById(int id) throws Exception {
        // Query order information
        Order order = orderMapper.getOrderById(id);
        if (order != null) {
            List<OrderItem> orderItems = orderItemMapper.getOrderByOrderId(order.getId());
            order.setOrderItems(orderItems);
            return order;
        }
        return null;
    }


    /**
     * Query the order information by query map
     *
     * @param queryMap query map
     * @return order information
     */
    @Override
    public List<Order> queryOrderByMap(Map queryMap) {
        List<Order> orders = orderMapper.getOrderByMap(queryMap);
        // Query all order item information
        if (orders != null && orders.size() > 0) {
            for (int i = 0, len = orders.size(); i < len; i++) {
                Order order = orders.get(i);
                List<OrderItem> orderItems = orderItemMapper.getOrderByOrderId(order.getId());
                order.setOrderItems(orderItems);
            }
            return orders;
        }
        return null;
    }

    /**
     * create order
     *
     * @param order order
     */
    @Override
    public boolean addOrder(Order order) throws Exception {
        if (order != null) {
            // Set order information
            order.setOrderDate(new Date());
            order.setStatus("0");
            orderMapper.addOrder(order);
            try {
                List<OrderItem> orderItemList = order.getOrderItems();
                // Input the order item and calculate the total price of the order
                for (int i = 0, len = orderItemList.size(); i < len; i++) {
                    OrderItem temp = orderItemList.get(i);
                    temp.setOrderId(order.getId());
                    orderItemMapper.addOrderItem(temp);
                }
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                throw new Exception("The order creation failed. Failure reason XXX");
            }
        }
        return false;
    }

}
