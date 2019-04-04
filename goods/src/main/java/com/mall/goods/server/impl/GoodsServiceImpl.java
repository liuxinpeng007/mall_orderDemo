package com.mall.goods.server.impl;

import com.mall.goods.entity.Goods;
import com.mall.goods.mapper.GoodsMapper;
import com.mall.goods.server.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Goods Service
 *
 * @author liuxinpeng
 * @data 2019/04/03
 */
@Service("goodsService")
public class GoodsServiceImpl implements IGoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public Goods getGoodsById(String id) {
        return goodsMapper.getGoodsById(id);
    }
}
