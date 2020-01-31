package com.snowy.bookstore.dao;

import com.snowy.bookstore.bean.Readtype;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @auther snowy
 * @date 2019/12/7 - 18:52
 */
@Repository
public interface ReadtypeMapper {
    /*查询读者类型信息*/
    List getReadtypeByAll();

}
