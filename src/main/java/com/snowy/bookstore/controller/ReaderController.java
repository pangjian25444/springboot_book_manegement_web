package com.snowy.bookstore.controller;

import com.snowy.bookstore.bean.Msg;
import com.snowy.bookstore.bean.Reader;
import com.snowy.bookstore.service.ReaderService;
import com.snowy.bookstore.service.ReadtypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @auther snowy
 * @date 2019/12/7 - 14:39
 */
@Controller
public class ReaderController {

    @Autowired
    ReadtypeService readtypeService;

    @Autowired
    ReaderService readerService;

    /*查询所有读者信息*/
    @GetMapping("/readerall")
    public String queryReaderAll( Map map){
        List readerAll = readerService.getReaderAll();
        map.put("reader",readerAll);
        return "readerfile";
    }

    /*查询单个读者信息*/
    @GetMapping("/readerone/{id}")
    @ResponseBody
    public Msg queryReaderOne(@PathVariable("id")Integer id){
        Reader readerOne = readerService.getReaderOne(id);
        return Msg.success().add("readers",readerOne);
    }
    /*查询读者类型信息*/
    @GetMapping("/readtype")
    @ResponseBody
    public Msg queryReadtypeAll(){
        List readtypeAll = readtypeService.getReadtypeAll();
        return Msg.success().add("readtypeAll",readtypeAll);
    }

    /*修改单个读者信息*/
    @PutMapping("/readerone/{id}")
    @ResponseBody
    public Msg updateReaderOne(@PathVariable("id")Integer id,Reader reader){
        return readerService.updateReaderByid(reader) ? Msg.success() : Msg.fail();

    }
    /*删除单个读者信息*/
    @DeleteMapping("/readerone/{id}")
    @ResponseBody
    public Msg deleteReaderOne(@PathVariable("id")Integer id){
        return readerService.deleteReaderOne(id) ? Msg.success() : Msg.fail();
    }

    /*查询单个读者信息barcode*/
    @GetMapping("/readeronebarcode/{barcode}")
    @ResponseBody
    public Msg queryReaderOneBarcode(@PathVariable("barcode")String barcode){
        Reader readerOneBarcode = readerService.getReaderOneBarcode(barcode);
        return Msg.success().add("reader",readerOneBarcode);
    }

}
