package com.example.mybatis_plus.service;

import com.example.mybatis_plus.bean.User;

import java.util.List;

public interface UserService {
    boolean save(User dto);
    boolean update(User dto);
    boolean delete(Integer id);
    User getById(Integer id);
    List<User> getUserList();
}
