package com.mall.order.controller;

import com.mall.order.entity.Order;
import com.mall.order.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<Order> getOrderByUserId(@PathVariable("userId") int userId) {
        try {
            Map<String, Object> queryMap = new HashMap<String, Object>();
            queryMap.put("userId", userId);
            return orderService.queryOrderByMap(queryMap);
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
    public List<Order> getOrderByUserIdAndStatus(@PathVariable("userId") int userId,
                                                 @PathVariable("status") int status) {
        try {
            Map<String, Object> queryMap = new HashMap<String, Object>();
            queryMap.put("userId", userId);
            queryMap.put("status", status);
            return orderService.queryOrderByMap(queryMap);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * create order
     *
     * @param order order information
     */
    @PostMapping("/order/add")
    public boolean addOrder(Order order) {
        try {
            return orderService.addOrder(order);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


}
