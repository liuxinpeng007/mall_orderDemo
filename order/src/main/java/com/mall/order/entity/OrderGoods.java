package com.mall.order.entity;

import java.util.List;

/**
 * Order 订单和商品详情类
 *
 * @author liuxinpeng
 * @data 2019/04/03
 */
public class OrderGoods {
    // 订单信息
    private Order order;
    // 商品列表信息
    private List<Goods> goodsList;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    @Override
    public String toString() {
        return "OrderGoods{" +
                "order=" + order +
                ", goodsList=" + goodsList +
                '}';
    }
}
