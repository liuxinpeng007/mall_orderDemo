package com.mall.product.service;


import com.mall.product.entity.Product;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface IProductService {

    /**
     * Query product information by product ID
     * @param id product ID
     * @return product information
     */
    Product getProductById(int id);

    /**
     * Query products information by product IDs
     * @param ids product IDs
     * @return product information list
     */
    List<Product> getProductsByIds(Collection<Integer> ids);
}
