package com.mall.order.remote.product;

import com.mall.product.entity.Product;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;
import java.util.List;

/**
 * Product remote client
 */
@FeignClient(value = "productServer")
public interface ProductRemoteClient {

    @GetMapping("/product/query/{id}")
    Product getProductById(@PathVariable("id") int id);

    @GetMapping("/product/querys")
    List<Product>  getProductsByIds(Collection<Integer> ids);
}
