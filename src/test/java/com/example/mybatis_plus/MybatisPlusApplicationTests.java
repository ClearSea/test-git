package com.example.mybatis_plus;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatis_plus.bean.User;
import com.example.mybatis_plus.mapper.UserMapper;
import com.example.mybatis_plus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MybatisPlusApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Test
    void contextLoads() {
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }

    @Test
    void pageSelect(){

        LambdaQueryWrapper<User> qw = new LambdaQueryWrapper();
        qw.eq(User::getAge,2);

        IPage page=new Page(2,2);
        userMapper.selectPage(page,qw);
//        List<User> records = page.getRecords();

    }

    @Autowired
    UserService userService;
    @Test
    void save(){
        User user = new User();
        user.setAge(99);
        user.setName("甄帅辉");
        userService.save(user);
    }
}
