package com.mall.user.service;

import com.mall.user.entity.User;

import java.util.List;

public interface IUserService {

    User getUserById(int id);

    List<User> getUsersByIds(List<Integer> ids);
}
