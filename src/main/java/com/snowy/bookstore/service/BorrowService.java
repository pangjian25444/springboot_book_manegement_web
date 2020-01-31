package com.snowy.bookstore.service;

import com.snowy.bookstore.bean.Borrow;
import com.snowy.bookstore.dao.BorrowMapper;
import com.snowy.bookstore.dao.BorrowtimeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @auther snowy
 * @date 2019/12/10 - 16:26
 */
@Service
public class BorrowService {
    @Autowired
    BorrowtimeMapper borrowtimeMapper;

    @Autowired
    ReaderService readerService;

    @Autowired
    BorrowMapper borrowMapper;

    /*读者借书*/
    @Transactional(rollbackFor= Exception.class)
    public boolean saveBorrowBook(Borrow borrow) {
            /*查读者是否借了同一本书*/
        if (borrowMapper.getBorrowByRidAndBid(borrow)==null){
                /*查询读者类型*/
            if (readerService.getReaderType(borrow.getRid()).getTypeid()==1){
                    /*根据读者类型制定借书策略*/
                if (borrowMapper.getReadtypeBookQuantity(borrow).size()>=0&&borrowMapper.getReadtypeBookQuantity(borrow).size()<2){
                    /*图书借阅次数加一*/
                    borrowtimeMapper.saveBorrowTime(borrow.getBid());
                    /*添加图书*/
                    return borrowMapper.saveBorrow(borrow)>0?true:false;
                }else {
                    return false;
                }
            }else {
                /*根据读者类型制定借书策略*/
                if (borrowMapper.getReadtypeBookQuantity(borrow).size()>=0&&borrowMapper.getReadtypeBookQuantity(borrow).size()<1){
                    /*图书借阅次数加一*/
                    borrowtimeMapper.saveBorrowTime(borrow.getBid());
                            /*添加图书*/
                    return borrowMapper.saveBorrow(borrow)>0?true:false;
                }else {
                    return false;
                }
            }
        }else {
            return false;
        }
    }

    /*查询读者的已经借阅的书籍*/
    public List< Borrow> getBorrowAndBookinfoByRid(Integer rid) {
        return borrowMapper.getBorrowBookinfoByRid(rid);
    }

    /*读者续借*/
    @Transactional
    public boolean updateborrow(Borrow borrow){
        borrow.setRepaytime(changeOfTime(borrow.getRepaytime()));
        if (borrowMapper.updateborrow(borrow)>0){
            /*图书借阅次数加一*/
            borrowtimeMapper.saveBorrowTime(borrow.getBid());
            return true;
        }else {
            return false;
        }
    }

    /*读者归还*/
    public boolean updateBorrowIfbook(Borrow borrow){
        return borrowMapper.updateBorrowByIfbook(borrow)>0?true:false;
    }


   /*增加5天*/
    public String changeOfTime(String time){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String REPAYTIME = time;
        Date repaytime = null;
        try {
            repaytime = formatter.parse(REPAYTIME);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long repaytimeTimeOne = repaytime.getTime()+5*24*60*60*1000;
        Date repaytimeTimeTwo = new Date(repaytimeTimeOne);
        String formatStr =formatter.format(repaytimeTimeTwo);
        return formatStr;
    }
}

    