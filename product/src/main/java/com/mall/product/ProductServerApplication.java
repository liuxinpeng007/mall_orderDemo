package com.mall.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * product Server Applicaiton
 *
 * @author liuxinpeng
 * @data 2019/04/03
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.mall.product.mapper")
public class ProductServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductServerApplication.class, args);
    }
}
