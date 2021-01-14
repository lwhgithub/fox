package com.fh.book.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 生产地址: FLYFOX第五号BUG工厂第二分厂三十三号生产员
 * 生产日期: 2021-01-05 11:38
 */
public class BookParam {
    private Integer bookId;// 序号
    private String bookName;//名称
    private BigDecimal bookPriceMin;//价格
    private BigDecimal bookPriceMax;//价格
    private String bookPeoples;//使用人群 复选框
    private Integer bookType;//类型   单选框
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date bookCreateDateMin;//出版时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date bookCreateDateMax;//出版时间
    private Integer bookArea;//销售地区  下拉框

    private List<String> ps;

    private long pagingSize=10;
    private long pagingStart=0;

    public List<String> getPs() {
        return ps;
    }

    public void setPs(List<String> ps) {
        this.ps = ps;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public BigDecimal getBookPriceMin() {
        return bookPriceMin;
    }

    public void setBookPriceMin(BigDecimal bookPriceMin) {
        this.bookPriceMin = bookPriceMin;
    }

    public BigDecimal getBookPriceMax() {
        return bookPriceMax;
    }

    public void setBookPriceMax(BigDecimal bookPriceMax) {
        this.bookPriceMax = bookPriceMax;
    }

    public String getBookPeoples() {
        return bookPeoples;
    }

    public void setBookPeoples(String bookPeoples) {
        this.bookPeoples = bookPeoples;
    }

    public Integer getBookType() {
        return bookType;
    }

    public void setBookType(Integer bookType) {
        this.bookType = bookType;
    }

    public Date getBookCreateDateMin() {
        return bookCreateDateMin;
    }

    public void setBookCreateDateMin(Date bookCreateDateMin) {
        this.bookCreateDateMin = bookCreateDateMin;
    }

    public Date getBookCreateDateMax() {
        return bookCreateDateMax;
    }

    public void setBookCreateDateMax(Date bookCreateDateMax) {
        this.bookCreateDateMax = bookCreateDateMax;
    }

    public Integer getBookArea() {
        return bookArea;
    }

    public void setBookArea(Integer bookArea) {
        this.bookArea = bookArea;
    }

    public long getPagingSize() {
        return pagingSize;
    }

    public void setPagingSize(long pagingSize) {
        this.pagingSize = pagingSize;
    }

    public long getPagingStart() {
        return pagingStart;
    }

    public void setPagingStart(long pagingStart) {
        this.pagingStart = pagingStart;
    }
}
