package com.mall.product.mapper;


import com.mall.product.entity.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Set;

/**
 * Good Mapper
 *
 * @author liuxinpeng
 * @data 2019/04/03
 */
@Mapper
public interface ProductMapper {

    Product getProductById(int id);

    List<Product> getProductsByIds(List<Integer> ids);
}