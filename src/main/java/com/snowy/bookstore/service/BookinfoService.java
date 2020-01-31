package com.snowy.bookstore.service;

import com.snowy.bookstore.bean.Bookinfo;
import com.snowy.bookstore.dao.BookinfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @auther snowy
 * @date 2019/12/7 - 13:37
 */
@Service
public class BookinfoService {
    private static Pattern PATTERN = Pattern.compile("[0-9]+");
    @Autowired
    BookinfoMapper bookinfoMapper;

    /*查询所有书籍带借阅次数*/
    public List getBookinfoAllWithTime() {
      return bookinfoMapper.getBookinfoByAllWithTime();
    }

    /*查询所有书籍*/
    public List < Bookinfo > getBookinfoAll() {
        return bookinfoMapper.getBookinfoByAll();
    }

    /*查询数据带条形码或者书名*/
    public List < Bookinfo > getBookifoOne(String wordsandnumbers) {
        /*定义wordsandnumbers的类型*/
        Matcher isNum = PATTERN.matcher(wordsandnumbers);

        String barcode=null;
        String bookname= null;
        /*判断wordsandnumbers是数字还是书名*/
        if (isNum.matches()){
            barcode=wordsandnumbers;
            return bookinfoMapper.getBookinfoByOne(barcode,bookname);
        }else {
            bookname=wordsandnumbers;
            return bookinfoMapper.getBookinfoByOne(barcode,bookname);
        }
    }
}
