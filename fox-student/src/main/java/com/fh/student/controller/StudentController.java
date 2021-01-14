package com.fh.student.controller;

import com.fh.common.ServerResponse;
import com.fh.student.model.Student;
import com.fh.student.model.StudentParam;
import com.fh.student.service.StudentService;

import com.fh.utils.ExportUtil;
import io.lettuce.core.dynamic.annotation.Param;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * 生产地址: FLYFOX第五号BUG工厂第二分厂三十三号生产员
 * 生产日期: 2020-12-28 19:51
 */
@RequestMapping("StudentController")
@RestController

public class StudentController {
    @Resource
    private StudentService studentService;

//   接口作用:       对t_student表的信息进行查询,分页
//   请求路径：      http://localhost:8111/aa/StudentController/queryStudent
//   请求类型：      get
//   接收参数：      com.fh.student.model.StudentParam
//   接收数据类型：  com.fh.student.model.StudentParam
//   必须参数:       无 默认提供pagingSize=10 pagingStart=0
//   返回值:         {"code":1111,"data":{"count":条数,"list":[{数据1},{数据2},...]},"message":"成功"}
//   返回值类型：    json
    @GetMapping("queryStudent")
    public ServerResponse queryStudent(StudentParam student){
        return studentService.queryStudent(student);
    }

//   接口作用:       对t_student表的信息进行根据id修改
//   请求路径：      http://localhost:8111/aa/StudentController/updateStudent
//   请求类型：      put
//   接收参数：      com.fh.student.model.Student
//   接收数据类型：  com.fh.student.model.Student
//   必须参数:       Integer类型: studentId;
//   返回值:         {"code":1111,"data":null,"message":"成功"}
//   返回值类型：    json
    @PutMapping("updateStudent")
    public ServerResponse updateStudent(Student student){
         return studentService.updateStudent(student);
    }

//   接口作用:       对t_student表的信息进行添加新的数据
//   请求路径：      http://localhost:8111/aa/StudentController/addStudent
//   请求类型：      post
//   接收参数：      com.fh.student.model.Student
//   接收数据类型：  com.fh.student.model.Student
//   必须参数:       String类型: studentName;String类型:studentPhone;
//   返回值:         {"code":1111,"data":null,"message":"成功"}
//   返回值类型：    json
    @PostMapping("addStudent")
    private ServerResponse addStudent(Student student){
        if(StringUtils.isBlank(student.getStudentName())){
            return ServerResponse.error("学生姓名不允许为空");
        }
        if(StringUtils.isBlank(student.getStudentPhone())){
            return ServerResponse.error("学生手机号不允许为空");
        }
        return  studentService.addStudent(student);
    }

//   接口作用:       对t_student表的信息进行根据id删除
//   请求路径：      http://localhost:8111/aa/StudentController/deleteStudent
//   请求类型：      delete
//   接收参数：      studentId
//   接收数据类型：  Integer
//   必须参数:       Integer类型: studentId;
//   返回值:         {"code":1111,"data":null,"message":"成功"}
//   返回值类型：    json
    @DeleteMapping("deleteStudent")
    private ServerResponse deleteStudent(Integer studentId){
        return studentService.deleteStudent(studentId);
    }

//   接口作用:       对t_student表的信息进行导出成excel文件,条件查询后执行会导出查询后的数据
//   请求路径：      http://localhost:8111/aa/StudentController/frmkexportExcel
//   请求类型：      无要求
//   接收参数：      无
//   接收数据类型：  无
//   必须参数:       无
//   返回值:         无
//   返回值类型：    无
    @GetMapping("frmkexportExcel")
    public void frmkexportExcel(HttpServletRequest request, HttpServletResponse response){
        try {
            // 1.查询要导出的数据
            List<Student> students = studentService.queryNoPage2();
            for (int i=0; i<students.size(); i++){
                students.get(i) .setStudentId(i+1);
            }
            //创建数据模型
            HashMap<Object, Object> dataMap = new HashMap<>();
            dataMap.put("students",students);
            // 3.调用工具类中的生成Word文档的方法
            File file = ExportUtil.generateWord("/template", "Student.ftl", dataMap, request);
            // 4.调用工具类中的下载方法
            ExportUtil.downloadFile(file,"飞狐教育学生信息统计.xlsx",request,response);
            // 5.删除项目发布路径下的垃圾数据
            file.delete();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
