package com.mall.order.entity;

/**
 * Order 订单详细类
 *
 * @author liuxinpeng
 * @data 2019/04/03
 */
public class OrderItem {
    // id
    private String id;
    // 订单ID
    private String orderId;
    // 商品ID
    private String goodsId;
    // 商品数量
    private int goodsNum;
    // 商品价格
    private float goodsPrice;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public int getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(int goodsNum) {
        this.goodsNum = goodsNum;
    }

    public float getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(float goodsPrice) {
        this.goodsPrice = goodsPrice;
    }
}
