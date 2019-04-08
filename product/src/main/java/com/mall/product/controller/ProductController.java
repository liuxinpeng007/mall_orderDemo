package com.mall.product.controller;

import com.mall.product.entity.Product;
import com.mall.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

/**
 * Product Controller
 *
 * @author liuxinpeng
 * @data 2019/04/03
 */
@RestController
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("/product/query/{id}")
    public Product getProductById(@PathVariable("id") int id) {
        return productService.getProductById(id);
    }

    @PostMapping("/product/querys")
    public List<Product> getProductsByIds(@RequestBody List<Integer> ids) {
        return productService.getProductsByIds(ids);
    }
}
