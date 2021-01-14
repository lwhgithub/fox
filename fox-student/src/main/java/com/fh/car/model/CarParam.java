package com.fh.car.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 生产地址: FLYFOX第五号BUG工厂第二分厂三十三号生产员
 * 生产日期: 2021-01-10 16:53
 */
public class CarParam {
    private String carname;
    private Integer carType;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date carcreateDateMax;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date carcreateDateMin;
    private BigDecimal carpriceMax;
    private BigDecimal carpriceMin;
    private Integer carbid;

    private long pagingSize=10;
    private long pagingStart=0;

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

    public Date getCarcreateDateMax() {
        return carcreateDateMax;
    }

    public void setCarcreateDateMax(Date carcreateDateMax) {
        this.carcreateDateMax = carcreateDateMax;
    }

    public Date getCarcreateDateMin() {
        return carcreateDateMin;
    }

    public void setCarcreateDateMin(Date carcreateDateMin) {
        this.carcreateDateMin = carcreateDateMin;
    }

    public BigDecimal getCarpriceMax() {
        return carpriceMax;
    }

    public void setCarpriceMax(BigDecimal carpriceMax) {
        this.carpriceMax = carpriceMax;
    }

    public BigDecimal getCarpriceMin() {
        return carpriceMin;
    }

    public void setCarpriceMin(BigDecimal carpriceMin) {
        this.carpriceMin = carpriceMin;
    }

    public Integer getCarbid() {
        return carbid;
    }

    public void setCarbid(Integer carbid) {
        this.carbid = carbid;
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
