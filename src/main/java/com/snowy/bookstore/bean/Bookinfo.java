package com.snowy.bookstore.bean;

/**
 * @auther snowy
 * @date 2019/12/7 - 13:16
 */
public class Bookinfo  {
    private Integer bid;
    private String bookname;
    private String booktype;
    private String author;
    private String translate;
    private String price;
    private String page;
    private String publish;
    private String barcode;
    private Borrowtime borrowtime;

    public Borrowtime getBorrowtime() {
        return borrowtime;
    }

    public void setBorrowtime(Borrowtime borrowtime) {
        this.borrowtime = borrowtime;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getBooktype() {
        return booktype;
    }

    public void setBooktype(String booktype) {
        this.booktype = booktype;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTranslate() {
        return translate;
    }

    public void setTranslate(String translate) {
        this.translate = translate;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

}
