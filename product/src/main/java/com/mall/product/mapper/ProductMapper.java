package com.mall.product.mapper;


import com.mall.product.entity.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.Collection;
import java.util.List;

/**
 * Good Mapper
 *
 * @author liuxinpeng
 * @data 2019/04/03
 */
@Mapper
public interface ProductMapper {

    Product getProductById(int id);

    List<Product> getProductsByIds(Collection<Integer> ids);
}
