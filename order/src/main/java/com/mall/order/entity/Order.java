package com.mall.order.entity;

import java.util.Date;
import java.util.List;

/**
 * Order
 *
 * @author liuxinpeng
 * @data 2019/04/03
 */
public class Order {

    private int id;
    private int userId;
    // create order time
    private Date orderDate;
    // status 0:pending payment, 1:paid, 2:cancel or delete the order
    private String status;
    // order total price
    private float amount;
    private List<OrderItem> orderItems;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
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

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
