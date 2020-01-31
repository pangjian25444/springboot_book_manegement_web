package com.snowy.bookstore.bean;

/**
 * @auther snowy
 * @date 2019/12/8 - 16:31
 */
public class Borrow {
    private Integer bwid;
    private Integer rid;
    private Integer bid;
    private String borrowtime;
    private String repaytime;
    private Integer ifbook;
    private Bookinfo bookinfo;

    public Bookinfo getBookinfo() {
        return bookinfo;
    }

    public void setBookinfo(Bookinfo bookinfo) {
        this.bookinfo = bookinfo;
    }

    public Integer getBwid() {
        return bwid;
    }

    public void setBwid(Integer bwid) {
        this.bwid = bwid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getBorrowtime() {
        return borrowtime;
    }

    public void setBorrowtime(String borrowtime) {
        this.borrowtime = borrowtime;
    }

    public String getRepaytime() {
        return repaytime;
    }

    public void setRepaytime(String repaytime) {
        this.repaytime = repaytime;
    }

    public Integer getIfbook() {
        return ifbook;
    }

    public void setIfbook(Integer ifbook) {
        this.ifbook = ifbook;
    }
}
