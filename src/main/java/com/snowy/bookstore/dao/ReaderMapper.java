package com.snowy.bookstore.dao;

import com.snowy.bookstore.bean.Reader;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @auther snowy
 * @date 2019/12/7 - 14:27
 */
@Repository
public interface ReaderMapper {

    /*查询所有用户信息*/
    List getReaderByAll();

    /*查询单个用户信息*/
    Reader getReaderByid(Integer id);

    /*修改用户信息*/
    int updateRerderByid( Reader reader);

    /*删除用户信息*/
    int deleteReaderByid(Integer id);
    /*用barcode查询单个读者信息 */
    Reader getReaderOneByBarcode(String barcode);

    /*查询读者是什么类型*/
    Reader getReaderTypeByid(Integer id);
}
