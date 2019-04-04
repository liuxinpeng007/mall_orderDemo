package com.mall.goods.mapper;

import com.mall.goods.entity.Goods;
import org.apache.ibatis.annotations.Mapper;

/**
 * Goods Mapper
 *
 * @author liuxinpeng
 * @data 2019/04/03
 */
@Mapper
public interface GoodsMapper {

    Goods getGoodsById(String id);
}
