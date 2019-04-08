package com.mall.user.service.impl;

import com.mall.user.entity.User;
import com.mall.user.mapper.UserMapper;
import com.mall.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(int id) {
        return userMapper.getUserById(id);
    }

    @Override
    public List<User> getUsersByIds(List<Integer> ids) {
        return userMapper.getUsersByIds(ids);
    }
}
