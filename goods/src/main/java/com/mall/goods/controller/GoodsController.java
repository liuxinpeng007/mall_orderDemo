package com.mall.goods.controller;

import com.mall.goods.entity.Goods;
import com.mall.goods.server.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
/**
 * Goods Controller
 *
 * @author liuxinpeng
 * @data 2019/04/03
 */
@RestController
public class GoodsController {

    @Autowired
    private IGoodsService goodsService;

    @GetMapping("/goods/query/{id}")
    public Goods getGoodsById(@PathVariable("id") String id) {
        return goodsService.getGoodsById(id);
    }
}
