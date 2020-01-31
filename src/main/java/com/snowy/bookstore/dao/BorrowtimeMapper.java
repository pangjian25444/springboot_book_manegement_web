package com.snowy.bookstore.dao;

import org.springframework.stereotype.Repository;

/**
 * @auther snowy
 * @date 2019/12/17 - 22:44
 */
@Repository
public interface BorrowtimeMapper {
    /*添加数据借阅次数*/
    int saveBorrowTime(Integer bid);
}
