package com.mall.order.controller;

import com.mall.order.entity.Order;
import com.mall.order.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Order Controller
 *
 * @author liuxinpeng
 * @data 2019/04/03
 */
@RestController
public class OrderController {

    @Autowired
    private IOrderService orderService;

    /**
     * Query the order information by order ID
     *
     * @param id order ID
     * @return order information
     */
    @GetMapping("/order/query/{id}")
    public Order getOrderById(@PathVariable("id") int id) {
        try {
            return orderService.getOrderById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Query the order information by user ID
     *
     * @param userId user ID
     * @return order information
     */
    @GetMapping("/order/query/user/{userId}")
    public List<Order> getOrdersByUserId(@PathVariable("userId") int userId) {
        try {
            Map<String, Object> queryMap = new HashMap<String, Object>();
            queryMap.put("userId", userId);
            return orderService.queryOrders(queryMap);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Query the order information by user ID and order status
     *
     * @param userId user ID
     * @return order information
     */
    @GetMapping("/order/query/user/{userId}/{status}")
    public List<Order> getOrdersByUserIdAndStatus(@PathVariable("userId") int userId,
                                                 @PathVariable("status") int status) {
        try {
            Map<String, Object> queryMap = new HashMap<String, Object>();
            queryMap.put("userId", userId);
            queryMap.put("status", status);
            return orderService.queryOrders(queryMap);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Create order
     *
     * @param order order information
     */
    @PostMapping("/order/add")
    public boolean addOrder(@RequestBody  Order order) {
        try {
            return orderService.addOrder(order);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Delete order
     *
     * @param id order ID
     */
    @DeleteMapping("/order/delete/{id}")
    public boolean deleteOrder(@PathVariable("id") Integer id) {
        try {
            return orderService.deleteOrder(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
