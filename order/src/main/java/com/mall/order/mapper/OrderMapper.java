package com.mall.order.mapper;

import com.mall.order.entity.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {

    Order getOrderById(String id);

    List<Order> getOrderByUserId(String userId);

    void addOrder(Order order);

}
