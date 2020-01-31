package com.snowy.bookstore.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @auther snowy
 * @date 2019/12/7 - 14:17
 */
public class Reader {
    private Integer rid;
    private Integer typeid;
    private String name;
    private Integer sex;
    private String barcode;
    private String birthday;
    private String papertype;
    private String paperno;
    private Readtype readtype;

    public Readtype getReadtype() {
        return readtype;
    }

    public void setReadtype(Readtype readtype) {
        this.readtype = readtype;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPapertype() {
        return papertype;
    }

    public void setPapertype(String papertype) {
        this.papertype = papertype;
    }

    public String getPaperno() {
        return paperno;
    }

    public void setPaperno(String paperno) {
        this.paperno = paperno;
    }
}
