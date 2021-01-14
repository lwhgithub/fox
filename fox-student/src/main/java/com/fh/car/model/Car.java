package com.fh.car.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 生产地址: FLYFOX第五号BUG工厂第二分厂三十三号生产员
 * 生产日期: 2021-01-10 16:53
 */
public class Car {
    private Integer carid;//	number(10)	主键ID
    private String carname;//	varchar2(120)	名称
    private Integer carType;//	number (3)	车辆类型	0  轿车，1  suv，2  跑车（页面写死）
    private String carimgPath;//	varchar2(120)	图片路径
    private String newcarimgPath;

    private BigDecimal carprice;//	Number（10）	价格
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date carcreateDate;//	Date	创建时间
    private Integer carbid;//	number(10)	外键	关联 fh_brand表（写成动态获取  数据自己在数据库添加）
    private Integer bid;//	number(10)	主键ID
    private String brandname;//	varchar2(120)	名称

    public String getNewcarimgPath() {
        return newcarimgPath;
    }

    public void setNewcarimgPath(String newcarimgPath) {
        this.newcarimgPath = newcarimgPath;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getBrandname() {
        return brandname;
    }

    public void setBrandname(String brandname) {
        this.brandname = brandname;
    }

    public Integer getCarid() {
        return carid;
    }

    public void setCarid(Integer carid) {
        this.carid = carid;
    }

    public String getCarname() {
        return carname;
    }

    public void setCarname(String carname) {
        this.carname = carname;
    }

    public Integer getCarType() {
        return carType;
    }

    public void setCarType(Integer carType) {
        this.carType = carType;
    }

    public String getCarimgPath() {
        return carimgPath;
    }

    public void setCarimgPath(String carimgPath) {
        this.carimgPath = carimgPath;
    }

    public BigDecimal getCarprice() {
        return carprice;
    }

    public void setCarprice(BigDecimal carprice) {
        this.carprice = carprice;
    }

    public Integer getCarbid() {
        return carbid;
    }

    public void setCarbid(Integer carbid) {
        this.carbid = carbid;
    }

    public Date getCarcreateDate() {
        return carcreateDate;
    }

    public void setCarcreateDate(Date carcreateDate) {
        this.carcreateDate = carcreateDate;
    }
}
