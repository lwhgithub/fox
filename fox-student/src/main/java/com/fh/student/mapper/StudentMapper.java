package com.fh.student.mapper;

import com.fh.common.ServerResponse;
import com.fh.student.model.Student;
import com.fh.student.model.StudentParam;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 生产地址: FLYFOX第五号BUG工厂第二分厂三十三号生产员
 * 生产日期: 2020-12-28 19:53
 */
public interface StudentMapper {

    @Select("<script> select * from t_student where 1=1 " +
            "<if test='studentName != null and studentName != &quot; &quot;'>  and studentName=#{studentName} </if> " +
            " <if test='studentBirthdayMin != null'> and studentBirthday &gt;= #{studentBirthdayMin} </if>  " +
            " <if test='studentBirthdayMax != null'> and studentBirthday &lt;= #{studentBirthdayMax} </if>  " +
            " <if test='studentAgeMin != null'> and studentAge &gt;= #{studentAgeMin} </if>  " +
            " <if test='studentAgeMax != null'> and studentAge &lt;= #{studentAgeMax} </if>  " +
            " order by studentId desc  limit #{pagingStart},#{pagingSize} </script>")
    List<Student> queryStudent(StudentParam student);

    @Select("<script> select count(*) from t_student where 1=1 " +
            "<if test='studentName != null and studentName != &quot; &quot;'>  and studentName=#{studentName} </if> " +
            " <if test='studentBirthdayMin != null'> and studentBirthday &gt;= #{studentBirthdayMin} </if>  " +
            " <if test='studentBirthdayMax != null'> and studentBirthday &lt;= #{studentBirthdayMax} </if>  " +
            " <if test='studentAgeMin != null'> and studentAge &gt;= #{studentAgeMin} </if>  " +
            " <if test='studentAgeMax != null'> and studentAge &lt;= #{studentAgeMax} </if>  " +
            "</script>")
    long queryCount(StudentParam student);

    @Update("        update t_student set studentName=#{studentName},studentSex=#{studentSex},\n" +
            "        studentAge=#{studentAge},studentEb=#{studentEb},studentPhone=#{studentPhone},\n" +
            "        studentPatriarchName=#{studentPatriarchName},studentPatriarchPhone=#{studentPatriarchPhone},\n" +
            "        homeAddress=#{homeAddress},studentBirthday=#{studentBirthday},idNumber=#{idNumber},timesOfRepetition=#{timesOfRepetition} where studentId=#{studentId};")
    void updateStudent(Student student);

    @Insert("   insert into t_student (studentName,studentSex,studentAge,studentEb,studentPhone,studentPatriarchName,studentPatriarchPhone,homeAddress,idNumber,timesOfRepetition,studentBirthday)\n" +
            "        values (#{studentName},#{studentSex},#{studentAge},#{studentEb},#{studentPhone},#{studentPatriarchName},#{studentPatriarchPhone},#{homeAddress},#{idNumber},#{timesOfRepetition},#{studentBirthday});\n" +
            "    ")
    void addStudent(Student student);

    @Select("select * from t_student;")
    List<Student> queryNoPage2();

    @Delete("delete from t_student where studentId =#{studentId}")
    void deleteStudent(Integer studentId);

}
