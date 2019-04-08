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
            List<OrderItem> orderItems = orderItemMapper.getOrderByOrderId(order.getId());
            // Fill in the order item information
            fillOrderItemsInfo(orderItems);
            order.setOrderItems(orderItems);
            // The user server is called remotely to query the user information
            User user = userRemoteClient.getUserById(order.getUserId());
            order.setUserAddress(user.getAddress());
            order.setUserPhone(user.getPhone());
            order.setUserName(user.getUserName());
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
        if (orders != null && orders.size() > 0) {
            // get all user id
            List<Integer> userIds = new ArrayList<Integer>();
            // all order Item;
            List<OrderItem> orderItemList = new ArrayList<OrderItem>();
            // Query all order item information
            for (int i = 0, len = orders.size(); i < len; i++) {
                Order order = orders.get(i);
                userIds.add(order.getUserId());
                List<OrderItem> orderItems = orderItemMapper.getOrderByOrderId(order.getId());
                orderItemList.addAll(orderItems);
                order.setOrderItems(orderItems);
            }
            // Fill in the order item information
            fillOrderItemsInfo(orderItemList);

            // Set the user information in the order
            List<User> userList = userRemoteClient.getUsersByIds(userIds);
            if (userList != null && userList.size() > 0) {
                for (int i = 0, len = orders.size(); i < len; i++) {
                    Order order = orders.get(i);
                    for (int j = 0, uLen = userList.size(); j < uLen; j++) {
                        User user = userList.get(j);
                        if (order.getUserId() == user.getId()) {
                            order.setUserName(user.getUserName());
                            order.setUserPhone(user.getPhone());
                            order.setUserAddress(user.getAddress());
                            break;
                        }
                    }
                }
            }
            return orders;
        }
        return null;
    }

    /**
     * Create order
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
                List<Integer> productIds = new ArrayList<Integer>();
                // get all product ids
                for (int i = 0, len = orderItems.size(); i < len; i++) {
                    productIds.add(orderItems.get(i).getProductId());
                }
                // The product server is called remotely to query the product information
                List<Product> products = productRemoteClient.getProductsByIds(productIds);
                // set product information
                for (int i = 0, len = orderItems.size(); i < len; i++) {
                    OrderItem orderItem = orderItems.get(i);
                    for (int j = 0, plen = products.size(); j < plen; j++) {
                        Product product = products.get(j);
                        if (orderItem.getProductId() == product.getId()) {
                            orderItem.setProductName(product.getProductName());
                            break;
                        }
                    }
                }
            }
        }
    }

}
