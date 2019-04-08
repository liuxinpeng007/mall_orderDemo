package com.mall.product.entity;

/**
 * Product
 *
 * @author liuxinpeng
 * @data 2019/04/03
 */
public class Product {
    private int id;
    private String productName;
    private float price;
    // status 0:put on shelves 1:pull off shelves
    private String status;
    private String createDate;
    private String lable;
    private String desctail;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }

    public String getDesctail() {
        return desctail;
    }

    public void setDesctail(String desctail) {
        this.desctail = desctail;
    }
}
