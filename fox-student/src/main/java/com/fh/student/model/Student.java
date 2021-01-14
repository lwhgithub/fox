package com.fh.student.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 生产地址: FLYFOX第五号BUG工厂第二分厂三十三号生产员
 * 生产日期: 2020-12-28 19:53
 */
public class Student {

    private Integer studentId;
    private String studentName;//姓名
    private Integer studentSex;// 性别
    private Integer studentAge;// 年龄
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date studentBirthday;//生日
    private String studentEb;// 学历
    private String studentPhone;// 个人电话
    private String studentPatriarchName;// 家长姓名
    private String studentPatriarchPhone;// 家长电话
    private String homeAddress;// 	家庭住址（必填身份证地址）
    private String idNumber;// 身份证号
    private Integer timesOfRepetition;// 末班次数

    private long pagingSize=10;
    private long pagingStart=0;

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", studentSex=" + studentSex +
                ", studentAge=" + studentAge +
                ", studentBirthday=" + studentBirthday +
                ", studentEb='" + studentEb + '\'' +
                ", studentPhone='" + studentPhone + '\'' +
                ", studentPatriarchName='" + studentPatriarchName + '\'' +
                ", studentPatriarchPhone='" + studentPatriarchPhone + '\'' +
                ", homeAddress='" + homeAddress + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", timesOfRepetition=" + timesOfRepetition +
                ", pagingSize=" + pagingSize +
                ", pagingStart=" + pagingStart +
                '}';
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getStudentSex() {
        return studentSex;
    }

    public void setStudentSex(Integer studentSex) {
        this.studentSex = studentSex;
    }

    public Integer getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(Integer studentAge) {
        this.studentAge = studentAge;
    }

    public Date getStudentBirthday() {
        return studentBirthday;
    }

    public void setStudentBirthday(Date studentBirthday) {
        this.studentBirthday = studentBirthday;
    }

    public String getStudentEb() {
        return studentEb;
    }

    public void setStudentEb(String studentEb) {
        this.studentEb = studentEb;
    }

    public String getStudentPhone() {
        return studentPhone;
    }

    public void setStudentPhone(String studentPhone) {
        this.studentPhone = studentPhone;
    }

    public String getStudentPatriarchName() {
        return studentPatriarchName;
    }

    public void setStudentPatriarchName(String studentPatriarchName) {
        this.studentPatriarchName = studentPatriarchName;
    }

    public String getStudentPatriarchPhone() {
        return studentPatriarchPhone;
    }

    public void setStudentPatriarchPhone(String studentPatriarchPhone) {
        this.studentPatriarchPhone = studentPatriarchPhone;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public Integer getTimesOfRepetition() {
        return timesOfRepetition;
    }

    public void setTimesOfRepetition(Integer timesOfRepetition) {
        this.timesOfRepetition = timesOfRepetition;
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
