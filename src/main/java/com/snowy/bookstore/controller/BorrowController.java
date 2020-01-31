package com.snowy.bookstore.controller;

import com.snowy.bookstore.bean.Borrow;
import com.snowy.bookstore.bean.Msg;
import com.snowy.bookstore.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @auther snowy
 * @date 2019/12/10 - 16:25
 */
@RestController
public class BorrowController {

    @Autowired
    BorrowService borrowService;

    /*读者借书*/
    @PostMapping("/borrow_reader/{id}")
    public Msg saveBorrowBook(@PathVariable("id")Integer id, Borrow borrow){
      return  borrowService.saveBorrowBook(borrow)?Msg.success():Msg.fail();
    }
    /*查询读者的已经借阅的书籍*/
    @GetMapping("/queryBorrowBookinfo/{rid}")
    public Msg queryBorrowBookinfo(@PathVariable("rid")Integer rid){
       List<Borrow> blist = borrowService.getBorrowAndBookinfoByRid(rid);
        return Msg.success().add("blist",blist);
    }

    /*读者续借*/
    @PutMapping("/borrow_reader/{rid}")
    public Msg readerRenewal(@PathVariable("rid")Integer rid, Borrow borrow){
        return borrowService.updateborrow(borrow)?Msg.success():Msg.fail();
    }

    /*读者归还*/
    @DeleteMapping("/borrow_reader/{rid}")
    public Msg readerReturn(@PathVariable("rid")Integer rid, Borrow borrow){
        return borrowService.updateBorrowIfbook(borrow)?Msg.success():Msg.fail();
    }

}
