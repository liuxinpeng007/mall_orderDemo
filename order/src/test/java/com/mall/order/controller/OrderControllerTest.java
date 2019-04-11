package com.mall.order.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mall.order.OrderServerApplication;
import com.mall.order.entity.Order;
import com.mall.order.entity.OrderItem;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OrderServerApplication.class)
@WebAppConfiguration
@ContextConfiguration
@Rollback
public class OrderControllerTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();
    }

    @Test
    public void testGetOrderById() throws Exception {
        RequestBuilder request = null;
        request = get("/order/query/2")
                .accept(MediaType.APPLICATION_JSON);
        mvc.perform(request)
                .andExpect(status().isOk())
                //.andExpect(content().string("1wqeqweqweqweqweq"))
                .andDo(print());
    }

    @Test
    public void testGetOrdersByUserId() throws Exception {
        RequestBuilder request = null;
        request = get("/order/query/user/1")
                .accept(MediaType.APPLICATION_JSON);
        mvc.perform(request)
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testGetOrdersByUserIdAndStatus() throws Exception {
        RequestBuilder request = null;
        request = get("/order/query/user/1/1")
                .accept(MediaType.APPLICATION_JSON);
        mvc.perform(request)
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    @Transactional
    public void testAddOrder() throws Exception {
        // build Order
        Order order = new Order();
        order.setAmount(18.8f);
        order.setUserId(1);
        List<OrderItem> orderItems = new ArrayList<OrderItem>();
        OrderItem orderItem = new OrderItem();
        orderItem.setProductId(1);
        orderItem.setProductNum(2);
        orderItems.add(orderItem);
        order.setOrderItems(orderItems);
        ObjectMapper mapper = new ObjectMapper();
        String orderJson = mapper.writeValueAsString(order);
        System.out.println("orderJson:" + orderJson);
        // test
        RequestBuilder request = null;
        request = post("/order/add")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(orderJson);
        mvc.perform(request)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }

    @Test
    @Transactional
    public void testDeleteOrder() throws Exception {
        RequestBuilder request = null;
        request = delete("/order/delete/2")
                .accept(MediaType.APPLICATION_JSON);
        mvc.perform(request)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }
}
