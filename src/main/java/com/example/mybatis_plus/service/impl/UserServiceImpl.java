package com.example.mybatis_plus.service.impl;

import com.example.mybatis_plus.bean.User;
import com.example.mybatis_plus.mapper.UserMapper;
import com.example.mybatis_plus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public boolean save(User dto) {
        return userMapper.insert(dto)>0;
    }

    @Override
    public boolean update(User dto) {
        return userMapper.updateById(dto)>0;
    }

    @Override
    public boolean delete(Integer id) {
        return userMapper.deleteById(id)>0;
    }

    @Override
    public User getById(Integer id) {
        return  userMapper.selectById(id);
    }

    @Override
    public List<User> getUserList() {
        return userMapper.selectList(null);
    }
}
