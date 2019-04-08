package com.mall.order.controller;

import com.mall.order.entity.Order;
import com.mall.order.entity.OrderItem;
import com.mall.order.service.IOrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceImplTest {

    @Autowired
    private IOrderService orderService;

    @Test
    public void testAddOrder() throws Exception {
        Order order = new Order();
        order.setAmount(207.5f);
        order.setUserId(1);
        List<OrderItem> orderItems = new ArrayList<OrderItem>();
        OrderItem orderItem = new OrderItem();
        orderItem.setProductId(1);
        orderItem.setProductNum(2);
        orderItem.setProductPrice(18.8f);

        OrderItem orderItem1 = new OrderItem();
        orderItem1.setProductId(2);
        orderItem1.setProductNum(1);
        orderItem1.setProductPrice(99.9f);

        OrderItem orderItem2 = new OrderItem();
        orderItem2.setProductId(3);
        orderItem2.setProductNum(1);
        orderItem2.setProductPrice(88.8f);

        orderItems.add(orderItem);
        orderItems.add(orderItem1);
        orderItems.add(orderItem2);
        order.setOrderItems(orderItems);

        orderService.addOrder(order);



    }
}
