package com.fh.book.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;


import java.math.BigDecimal;
import java.util.Date;

/**
 * 生产地址: FLYFOX第五号BUG工厂第二分厂三十三号生产员
 * 生产日期: 2021-01-05 11:38
 */
public class Book {
    private Integer bookId;// 序号
    private String bookName;//名称
    private BigDecimal bookPrice;//价格
    private String bookPeoples;//使用人群复选框
    private Integer bookType;//类型单选框
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date bookCreateDate;//出版时间
    private Integer bookArea;//销售地区下拉框

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", bookPrice=" + bookPrice +
                ", bookPeoples='" + bookPeoples + '\'' +
                ", bookType=" + bookType +
                ", bookCreateDate=" + bookCreateDate +
                ", bookArea=" + bookArea +
                '}';
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

    public BigDecimal getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(BigDecimal bookPrice) {
        this.bookPrice = bookPrice;
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

    public Date getBookCreateDate() {
        return bookCreateDate;
    }

    public void setBookCreateDate(Date bookCreateDate) {
        this.bookCreateDate = bookCreateDate;
    }

    public Integer getBookArea() {
        return bookArea;
    }

    public void setBookArea(Integer bookArea) {
        this.bookArea = bookArea;
    }
}
