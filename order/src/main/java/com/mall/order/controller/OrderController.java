package com.mall.order.controller;

import com.mall.order.entity.Goods;
import com.mall.order.entity.OrderGoods;
import com.mall.order.service.impl.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
     * 根据订单ID查询订单信息
     *
     * @param id 订单ID
     * @return 订单信息
     */
    @GetMapping("/order/query/{id}")
    public OrderGoods getOrderById(@PathVariable("id") String id) {
         return orderService.getOrderById(id);
    }

    /**
     * 根据用户ID查询订单信息
     *
     * @param userId 用户ID
     * @return 订单信息
     */
    @GetMapping("/order/query/user/{userId}")
    public List<OrderGoods> getOrderByUserId(@PathVariable("userId") String userId) {
        return orderService.getOrderByUserId(userId);
    }

    /**
     * 生成订单
     *
     * @param goods 商品信息
     */
    @PostMapping("/order/add")
    public boolean addOrder(List<Goods> goods) {
        try {
            return orderService.addOrder(goods);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


}
