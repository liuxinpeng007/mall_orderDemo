package com.mall.product.service.impl;


import com.mall.product.entity.Product;
import com.mall.product.mapper.ProductMapper;
import com.mall.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Product Service
 *
 * @author liuxinpeng
 * @data 2019/04/03
 */
@Service("productServiceImpl")
public class ProductServiceImpl implements IProductService {
    @Autowired
    private ProductMapper productMapper;

    /**
     * Query product information by good ID
     * @param id product ID
     * @return product information
     */
    @Override
    public Product getProductById(int id) {
        return productMapper.getProductById(id);
    }

    @Override
    public List<Product> getProductsByIds(Collection<Integer> ids) {
        return productMapper.getProductsByIds(ids);
    }
}
