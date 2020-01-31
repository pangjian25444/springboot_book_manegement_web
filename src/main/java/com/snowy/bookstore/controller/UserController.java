package com.snowy.bookstore.controller;

import com.snowy.bookstore.bean.Msg;
import com.snowy.bookstore.bean.User;
import com.snowy.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @auther snowy
 * @date 2019/12/6 - 0:12
 */
@Controller
public class UserController {

    @Autowired
    UserService userService;

    //登录
    @PostMapping("/login")
    @ResponseBody
    public Msg getUserLogin(User user,HttpSession session){
        if (userService.getUserLogin(user)!=null){
            session.setAttribute("user",user.getUsername());
            return  Msg.success().add("username",user.getUsername());
        }else {
            return Msg.fail();
        }
    }

}
