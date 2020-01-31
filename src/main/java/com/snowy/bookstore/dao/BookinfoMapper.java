package com.snowy.bookstore.dao;

import com.snowy.bookstore.bean.Bookinfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @auther snowy
 * @date 2019/12/7 - 13:08
 */
@Repository
public interface BookinfoMapper {
    /*查询所有书籍带借阅次数*/
    List getBookinfoByAllWithTime();

    /*查询所有书籍*/
    List< Bookinfo > getBookinfoByAll();

    /*查询书籍带有条形码或者名字*/
    List< Bookinfo > getBookinfoByOne(@Param("barcode")String barcode, @Param("bookname")String bookname);
}
