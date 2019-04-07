package com.mall.order.mapper;

import com.mall.order.entity.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface OrderMapper {

    Order getOrderById(int id);

    List<Order> getOrderByMap(Map queryMap);

    int addOrder(Order order);

}
