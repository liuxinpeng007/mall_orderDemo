package com.mall.order.feign;

import com.mall.order.entity.Goods;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "goodsServer")
public interface GoodsFeignClient {
    @GetMapping(value = "/goods/query/{id}")
    public Goods getGoodsById(@PathVariable("id") String id);
}