package com.snowy.bookstore.dao;

import com.snowy.bookstore.bean.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @auther snowy
 * @date 2019/12/5 - 23:52
 */
@Repository
public interface UserMapper {
    User getUserByUser(User user);
}
