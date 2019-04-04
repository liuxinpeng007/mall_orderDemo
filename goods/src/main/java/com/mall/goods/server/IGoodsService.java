package com.mall.goods.server;

import com.mall.goods.entity.Goods;

public interface IGoodsService {

    /**
     * 根据商品ID查询商品
     * @param id 商品ID
     * @return 商品信息
     */
    Goods getGoodsById(String id);
}
