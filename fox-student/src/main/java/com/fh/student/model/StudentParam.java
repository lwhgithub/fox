package com.fh.student.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 生产地址: FLYFOX第五号BUG工厂第二分厂三十三号生产员
 * 生产日期: 2020-12-28 20:54
 */
public class StudentParam {

    private String studentName;//姓名
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date studentBirthdayMin;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date studentBirthdayMax;
    private Integer studentAgeMin;
    private Integer studentAgeMax;

    private long pagingSize=10;
    private long pagingStart=0;

    @Override
    public String toString() {
        return "StudentParam{" +
                "studentName='" + studentName + '\'' +
                ", studentBirthdayMin=" + studentBirthdayMin +
                ", studentBirthdayMax=" + studentBirthdayMax +
                ", studentAgeMin=" + studentAgeMin +
                ", studentAgeMax=" + studentAgeMax +
                ", pagingSize=" + pagingSize +
                ", pagingStart=" + pagingStart +
                '}';
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Date getStudentBirthdayMin() {
        return studentBirthdayMin;
    }

    public void setStudentBirthdayMin(Date studentBirthdayMin) {
        this.studentBirthdayMin = studentBirthdayMin;
    }

    public Date getStudentBirthdayMax() {
        return studentBirthdayMax;
    }

    public void setStudentBirthdayMax(Date studentBirthdayMax) {
        this.studentBirthdayMax = studentBirthdayMax;
    }

    public Integer getStudentAgeMin() {
        return studentAgeMin;
    }

    public void setStudentAgeMin(Integer studentAgeMin) {
        this.studentAgeMin = studentAgeMin;
    }

    public Integer getStudentAgeMax() {
        return studentAgeMax;
    }

    public void setStudentAgeMax(Integer studentAgeMax) {
        this.studentAgeMax = studentAgeMax;
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
