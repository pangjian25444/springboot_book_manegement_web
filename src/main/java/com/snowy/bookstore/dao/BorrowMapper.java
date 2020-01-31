package com.snowy.bookstore.dao;

import com.snowy.bookstore.bean.Borrow;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @auther snowy
 * @date 2019/12/8 - 16:34
 */
@Repository
public interface BorrowMapper {
    /*查询用户借书是否归还*/
    List getBorrow(Integer id);

    /*查询是否是同一本书*/
    Borrow getBorrowByRidAndBid(Borrow borrow);

    /*读者借书*/
    int saveBorrow(Borrow borrow);

    /*查询读者的借阅的书籍*/
    List getReadtypeBookQuantity(Borrow borrow);

    /*查询读者的已经借阅的书籍*/
    List< Borrow> getBorrowBookinfoByRid(Integer rid);

    /*读者续借*/
    int updateborrow(Borrow borrow);

    /*读者归还*/
    int updateBorrowByIfbook(Borrow borrow);
}
