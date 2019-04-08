package com.mall.user.controller;

import com.mall.user.entity.User;
import com.mall.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/user/query/{id}")
    public User getUserById(@PathVariable("id") int id) {
        return userService.getUserById(id);
    }

    @PostMapping("/user/querys")
    public List<User> getUsersByIds(@RequestBody List<Integer> ids) {
        return userService.getUsersByIds(ids);
    }

}
