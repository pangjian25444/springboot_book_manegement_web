package com.snowy.bookstore.service;

import com.snowy.bookstore.bean.Reader;
import com.snowy.bookstore.dao.BorrowMapper;
import com.snowy.bookstore.dao.ReaderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auther snowy
 * @date 2019/12/7 - 14:38
 */
@Service
public class ReaderService {

    @Autowired
    ReaderMapper readerMapper;

    @Autowired
    BorrowMapper borrowMapper;

    /*查询所有读者信息*/
    public List getReaderAll() {
        return  readerMapper.getReaderByAll();
    }

    /*查询单个读者信息*/
    public Reader getReaderOne(Integer id) {
        return readerMapper.getReaderByid(id);
    }

    /*修改单个读者信息*/
    public boolean updateReaderByid(Reader reader) {
        return readerMapper.updateRerderByid(reader)> 0 ? true:false;
    }

    /*删除单个读者信息*/
    public boolean deleteReaderOne(Integer id) {
            /*判断读者归还所有书籍*/
        if (borrowMapper.getBorrow(id)==null){
            return readerMapper.deleteReaderByid(id)>0 ? true:false;
        }else {
            return false;
        }
    }
    /*查询单个读者信息barcode*/
    public Reader getReaderOneBarcode(String barcode){
        return  readerMapper.getReaderOneByBarcode(barcode);
    }


    public Reader getReaderType(Integer id) {
        return  readerMapper.getReaderTypeByid(id);
    }
}
