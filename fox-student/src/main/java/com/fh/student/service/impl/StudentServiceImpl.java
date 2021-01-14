package com.fh.student.service.impl;

import com.fh.common.ServerResponse;
import com.fh.student.mapper.StudentMapper;
import com.fh.student.model.Student;
import com.fh.student.model.StudentParam;
import com.fh.student.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 生产地址: FLYFOX第五号BUG工厂第二分厂三十三号生产员
 * 生产日期: 2020-12-28 19:54
 */
@Service

public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentMapper studentMapper;


    @Override
    public ServerResponse queryStudent(StudentParam student) {
        List<Student> list = studentMapper.queryStudent(student);
        long count = studentMapper.queryCount(student);
        Map<String,Object>  map = new HashMap<>();
        map.put("list",list);
        map.put("count",count);
        return ServerResponse.success(map);
    }

    @Override
    public ServerResponse updateStudent(Student student) {
        studentMapper.updateStudent(student);
        return ServerResponse.success();
    }

    @Override
    public ServerResponse addStudent(Student student) {
        studentMapper.addStudent(student);
        return ServerResponse.success();
    }

    @Override
    public ServerResponse deleteStudent(Integer studentId) {
        studentMapper.deleteStudent(studentId);
        return ServerResponse.success();
    }

    @Override
    public List queryNoPage2() {
        List<Student> list =  studentMapper.queryNoPage2();
        return list;
    }



}
