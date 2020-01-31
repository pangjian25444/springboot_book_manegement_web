package com.snowy.bookstore.service;

import com.snowy.bookstore.bean.Readtype;
import com.snowy.bookstore.dao.ReadtypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auther snowy
 * @date 2019/12/7 - 18:51
 */
@Service
public class ReadtypeService {
    @Autowired
    ReadtypeMapper readtypeMapper;

    /*查询读者类型信息*/
    public List getReadtypeAll() {
        return readtypeMapper.getReadtypeByAll();
    }
}
