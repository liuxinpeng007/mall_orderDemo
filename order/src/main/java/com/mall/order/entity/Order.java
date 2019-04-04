package com.mall.order.entity;

import java.util.Date;

/**
 * Order 订单类
 *
 * @author liuxinpeng
 * @data 2019/04/03
 */
public class Order {

    // 订单id
    private String id;
    // 用户ID
    private String userId;
    // 创建订单时间
    private Date orderDate;
    // 订单状态 0：待付款、1：已付款、2：已付款、3：取消或删除订单
    private String status;
    // 支付日期
    //private Date payDate;
    // 订单金额
    private float amount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", orderDate=" + orderDate +
                ", status='" + status + '\'' +
                ", amount=" + amount +
                '}';
    }
}
