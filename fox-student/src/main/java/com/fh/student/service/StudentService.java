package com.fh.student.service;

import com.fh.common.ServerResponse;
import com.fh.student.model.Student;
import com.fh.student.model.StudentParam;

import java.util.List;

/**
 * 生产地址: FLYFOX第五号BUG工厂第二分厂三十三号生产员
 * 生产日期: 2020-12-28 19:53
 */
public interface StudentService {

    ServerResponse queryStudent(StudentParam student);

    List<Student> queryNoPage2();

    ServerResponse updateStudent(Student student);

    ServerResponse deleteStudent(Integer studentId);

    ServerResponse addStudent(Student student);
}
