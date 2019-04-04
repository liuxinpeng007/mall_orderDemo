package com.mall.order.mapper;

import com.mall.order.entity.OrderItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface OrderItemMapper {

    List<OrderItem> getOrderByOrderId(String orderId);

    void addOrderItem(OrderItem item);

}
