package com.snowy.bookstore.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.snowy.bookstore.bean.Bookinfo;
import com.snowy.bookstore.bean.Msg;
import com.snowy.bookstore.service.BookinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @auther snowy
 * @date 2019/12/7 - 13:38
 */
@Controller
public class BookinfoController {

    @Autowired
    BookinfoService bookinfoService;

    /*查询所有书籍带借阅次数*/
    @GetMapping("/mains")
    public String getMianAndBookinfoAll(Map map){
        List bookinfoAll = bookinfoService.getBookinfoAllWithTime();
        map.put("bookall",bookinfoAll);
        return "main";
    }
    /*查询所有书籍*/
    @GetMapping("/bookinfoAll")
    @ResponseBody
    public Msg getBookinfoAll(@RequestParam(value = "pn",defaultValue = "1")Integer pn, Model model){
        //引入PageHelper分页查询的组件 传入页码 以及页码大小
        PageHelper.startPage(pn,5);
        List<Bookinfo> bookinfoList = bookinfoService.getBookinfoAll();
        PageInfo page = new PageInfo(bookinfoList,5);
        return Msg.success().add("bookinfopage",page);
    }
    /*查询单本书籍信息和借书情况*/
    @GetMapping("/bookinfoOne/{wordsandnumbers}")
    @ResponseBody
    public Msg getBookinfoOne(@PathVariable("wordsandnumbers")String wordsandnumbers){
        List < Bookinfo > bookifoOne = bookinfoService.getBookifoOne(wordsandnumbers);
        return Msg.success().add("bookifoOne",bookifoOne);
    }

}
