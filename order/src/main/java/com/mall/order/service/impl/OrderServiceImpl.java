package com.mall.order.service.impl;

import com.mall.order.entity.Order;
import com.mall.order.entity.OrderItem;
import com.mall.order.mapper.OrderItemMapper;
import com.mall.order.mapper.OrderMapper;
import com.mall.order.remote.product.ProductRemoteClient;
import com.mall.order.remote.user.UserRemoteClient;
import com.mall.order.service.IOrderService;
import com.mall.product.entity.Product;
import com.mall.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


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

    @Autowired
    private ProductRemoteClient productRemoteClient;

    @Autowired
    private UserRemoteClient userRemoteClient;

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
            List<OrderItem> orderItems = orderItemMapper.getOrderItemsByOrderId(order.getId());
            order.setOrderItems(orderItems);
            return order;
        }
        return null;
    }


    /**
     * Query the orders information by query map
     *
     * @param queryMap query map
     * @return orders information
     */
    @Override
    public List<Order> queryOrders(Map queryMap) {
        List<Order> orders = orderMapper.getOrderByMap(queryMap);
        if (orders != null && orders.size() > 0) {
            // Query all order item information
            for (int i = 0, len = orders.size(); i < len; i++) {
                Order order = orders.get(i);
                List<OrderItem> orderItems = orderItemMapper.getOrderItemsByOrderId(order.getId());
                order.setOrderItems(orderItems);
            }
            return orders;
        }
        return null;
    }

    /**
     * Create order
     *
     * @param order orderf
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public boolean addOrder(Order order) throws Exception {
        if (order != null) {
            // set order information
            order.setOrderDate(new Date());
            order.setStatus("0");
            // query user information
            User user = userRemoteClient.getUserById(order.getUserId());
            order.setUserAddress(user.getAddress());
            order.setUserPhone(user.getPhone());
            order.setUserName(user.getUserName());
            orderMapper.addOrder(order);
            try {
                List<OrderItem> orderItemList = order.getOrderItems();
                if (orderItemList != null) {
                    // fill in the order item information
                    fillOrderItemsInfo(orderItemList);
                    // set orderId
                    for (int i = 0, len = orderItemList.size(); i < len; i++) {
                        OrderItem temp = orderItemList.get(i);
                        temp.setOrderId(order.getId());
                        orderItemMapper.addOrderItem(temp);
                    }
                }
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                throw new Exception("The order creation failed. Failure reason XXX");
            }
        }
        return false;
    }

    /**
     * Fill in the order item information
     *
     * @param orderItems order item list
     */
    private void fillOrderItemsInfo(List<OrderItem> orderItems) {
        if (orderItems != null && orderItems.size() > 0) {
            // Just one order item
            if (orderItems.size() == 1) {
                OrderItem orderItem = orderItems.get(0);
                Product product = productRemoteClient.getProductById(orderItem.getProductId());
                orderItem.setProductName(product.getProductName());
            } else {
                // Multiple order items
                Set<Integer> productIds = new HashSet<Integer>();
                // get all product ids
                for (int i = 0, len = orderItems.size(); i < len; i++) {
                    productIds.add(orderItems.get(i).getProductId());
                }
                // The product server is called remotely to query the product information
                List<Product> products = productRemoteClient.getProductsByIds(productIds);
                Map<Integer, Product> productMap = new HashMap<Integer, Product>();
                for (int i = 0, len = orderItems.size(); i < len; i++) {
                    Product product = products.get(i);
                    productMap.put(product.getId(), product);
                }
                // set product information
                for (int i = 0, len = orderItems.size(); i < len; i++) {
                    OrderItem orderItem = orderItems.get(i);
                    Product product = productMap.get(orderItem.getProductId());
                    orderItem.setProductName(product.getProductName());
                }
            }
        }
    }

}
