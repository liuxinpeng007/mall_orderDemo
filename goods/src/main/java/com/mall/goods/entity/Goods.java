package com.mall.goods.entity;

/**
 * Goods 商品类
 *
 * @author liuxinpeng
 * @data 2019/04/03
 */
public class Goods {
    // 商品ID
    private String id;
    // 商品名称
    private String goodsName;
    // 商品价格
    private float price;
    // 商品状态 0：下架、1：上架
    private String status;
    // 商品创建时间
    private String createDate;
    // 商品标签
    private String lable;
    // 商品描述
    private String desctail;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
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

    public String getDesc() {
        return desctail;
    }

    public void setDesc(String desctail) {
        this.desctail = desctail;
    }
}
