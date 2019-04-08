package com.mall.order.remote.user;

import com.mall.user.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * User remote client
 */
@FeignClient(value = "userServer")
public interface UserRemoteClient {


    @GetMapping("/user/query/{id}")
    User getUserById(@PathVariable("id") int id);

    @PostMapping("/user/querys")
    List<User> getUsersByIds(List<Integer> ids);
}
