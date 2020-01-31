package com.snowy.bookstore.service;

import com.snowy.bookstore.bean.User;
import com.snowy.bookstore.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @auther snowy
 * @date 2019/12/6 - 14:57
 */
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    /*登录*/
    public User getUserLogin(User user){
        return userMapper.getUserByUser(user);
    }

}
