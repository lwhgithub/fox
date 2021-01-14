<template>
<div>
  <div style="float: right">
    <el-button type="success" @click="addbutton = true" plain>添加</el-button>
  </div>
  <!--      分页-->
  <div class="block" align="center">
    <!--      style="float:right"-->
    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="currentPage4"
      :page-sizes="xsts"
      :page-size="100"
      layout="total, sizes, prev, pager, next, jumper"
      :total="total"
    >
    </el-pagination>
  </div>
<!--  添加-->
  <el-dialog title="添加" :visible.sync="addbutton">
    <!--      表单部分-->
    <el-form :model="addStudentForm" ref="addStudentForm" >
      <el-form-item label="姓名" :label-width="formLabelWidth">
        <el-input v-model="addStudentForm.studentName" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="性别" :label-width="formLabelWidth">
        <div align="left">
          <el-radio v-model="addStudentForm.studentSex" :label="1" >男</el-radio>
          <el-radio v-model="addStudentForm.studentSex" :label="2" >女</el-radio>
        </div>
      </el-form-item>
      <el-form-item label="年龄" :label-width="formLabelWidth">
        <el-input v-model="addStudentForm.studentAge" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="生日" :label-width="formLabelWidth">
        <div align="left">
          <el-date-picker v-model="addStudentForm.studentBirthday" type="date" value-format="yyyy-MM-dd" placeholder="选择日期" style="width: 300px"></el-date-picker>
        </div>
      </el-form-item>
      <el-form-item label="学历" :label-width="formLabelWidth">
        <el-input v-model="addStudentForm.studentEb" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="个人电话" :label-width="formLabelWidth">
        <el-input v-model="addStudentForm.studentPhone" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="家长姓名" :label-width="formLabelWidth">
        <el-input v-model="addStudentForm.studentPatriarchName" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="家长电话" :label-width="formLabelWidth">
        <el-input v-model="addStudentForm.studentPatriarchPhone" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="家庭住址" :label-width="formLabelWidth">
        <el-input v-model="addStudentForm.homeAddress" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="身份证号" :label-width="formLabelWidth">
        <el-input v-model="addStudentForm.idNumber" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="末班次数" :label-width="formLabelWidth">
        <el-input v-model="addStudentForm.timesOfRepetition" autocomplete="off"></el-input>
      </el-form-item>

    </el-form>
    <!--      按钮部分-->
    <div slot="footer" class="dialog-footer">
      <el-button @click="addoff()">取 消</el-button>
      <el-button type="primary" @click="addStudent()">确 定</el-button>
    </div>
  </el-dialog>
<!--  查询-->
  <el-table :data="student" border style="width: 100%" @selection-change="handleSelectionChange" >
    <el-table-column type="selection" width="50"></el-table-column>
    <el-table-column label="展示序号" width="80" >
      <template slot-scope="scope">
        {{ scope.$index+1}}
      </template>
    </el-table-column>
    <!--    fixed    固定为第一列-->
    <el-table-column prop="studentName" label="姓名" width="50"> </el-table-column>
    <el-table-column prop="studentSex" label="性别" width="50">
      <template slot-scope="scope">
        {{ scope.row.studentSex==1?'男':scope.row.studentSex==2?'女':'未知'}}
      </template>
    </el-table-column>
    <el-table-column prop="studentAge" label="年龄" width="50"></el-table-column>
    <el-table-column prop="studentBirthday" label="生日" ></el-table-column>
    <el-table-column prop="studentEb" label="学历" width="50"></el-table-column>
    <el-table-column prop="studentPhone" label="个人电话"></el-table-column>
    <el-table-column prop="studentPatriarchName" label="家长姓名" ></el-table-column>
    <el-table-column prop="studentPatriarchPhone" label="家长电话" ></el-table-column>
    <el-table-column prop="homeAddress" label="家庭住址" ></el-table-column>
    <el-table-column prop="idNumber" label="身份证号" ></el-table-column>
    <el-table-column prop="timesOfRepetition" label="末班次数" width="50"></el-table-column>
    <el-table-column label="操作">
      <template slot-scope="scope">
        <el-row>
          <el-button type="primary" icon="el-icon-edit" @click="hx(scope.row)" circle></el-button>
          <el-button type="danger" icon="el-icon-delete" @click="del(scope.row)" circle></el-button>
        </el-row>
      </template>
    </el-table-column>
  </el-table>
<!--  修改-->
  <el-dialog title="修改" :visible.sync="updatebutton" >
    <!--      表单部分-->
    <el-form :model="updateStudentForm" ref="updateStudentForm" >
      <el-form-item label="姓名" :label-width="formLabelWidth">
        <el-input v-model="updateStudentForm.studentName" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="性别" :label-width="formLabelWidth">
        <div align="left">
          <el-radio v-model="updateStudentForm.studentSex" :label="1" >男</el-radio>
          <el-radio v-model="updateStudentForm.studentSex" :label="2" >女</el-radio>
        </div>
      </el-form-item>
      <el-form-item label="年龄" :label-width="formLabelWidth">
        <el-input v-model="updateStudentForm.studentAge" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="生日" :label-width="formLabelWidth">
        <div align="left">
          <el-date-picker v-model="updateStudentForm.studentBirthday" type="date" value-format="yyyy-MM-dd" placeholder="选择日期" style="width: 300px"></el-date-picker>
        </div>
      </el-form-item>
      <el-form-item label="学历" :label-width="formLabelWidth">
        <el-input v-model="updateStudentForm.studentEb" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="个人电话" :label-width="formLabelWidth">
        <el-input v-model="updateStudentForm.studentPhone" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="家长姓名" :label-width="formLabelWidth">
        <el-input v-model="updateStudentForm.studentPatriarchName" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="家长电话" :label-width="formLabelWidth">
        <el-input v-model="updateStudentForm.studentPatriarchPhone" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="家庭住址" :label-width="formLabelWidth">
        <el-input v-model="updateStudentForm.homeAddress" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="身份证号" :label-width="formLabelWidth">
        <el-input v-model="updateStudentForm.idNumber" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="末班次数" :label-width="formLabelWidth">
        <el-input v-model="updateStudentForm.timesOfRepetition" autocomplete="off"></el-input>
      </el-form-item>
    </el-form>
    <!--      按钮部分-->
    <div slot="footer" class="dialog-footer">
      <el-button @click="updateoff()">取 消</el-button>
      <el-button type="primary" @click="updateStudent()">确 定</el-button>
    </div>
  </el-dialog>
</div>
</template>

<script>
  export default {
    name: '',
    data(){
      return {
        // 头部复选框
        multipleSelection:[],
        // 控制添加的表单
        addbutton:false,
        // 添加的表单数据
        addStudentForm:{
            studentName:'',
            tudentSex:'',
            studentAge:'',
            studentBirthday:'',
            studentEb:'',
            studentPhone:'',
            studentPatriarchName:'',
            studentPatriarchPhone:'',
            homeAddress:'',
            idNumber:'',
            timesOfRepetition:'',
        },
        // 控制修改的表单
        updatebutton:false,
        // 修改的表单数据
        updateStudentForm:{
          studentId:'',
          studentName:'',
          studentSex:'',
          studentAge:'',
          studentBirthday:'',
          studentEb:'',
          studentPhone:'',
          studentPatriarchName:'',
          studentPatriarchPhone:'',
          homeAddress:'',
          idNumber:'',
          timesOfRepetition:'',
        },
        //宽度
        formLabelWidth: '120px',
        student:[],
        //分页条件查询
        currentPage4: 0,
        total:0,
        xsts:[3,4,5,6,7,8,9,10],
        paging:{
          pagingStart:0,
          pagingSize:3,
        },
      }
    },
    methods:{
      // 查询学生信息
      queryStudent () {
        var self = this;
        this.$axios.get("api/aa/StudentController/queryStudent?"+this.$qs.stringify(this.paging)).then(function (res) {
          console.log(res.data)
          if (res.data.code == 1111) {
            self.student=res.data.data.list;
            self.total=res.data.data.count;
          }
        })
      },

      // 添加取消
      addoff(){
        this.addStudentForm={};
        this.addbutton=false;
      },
      // 添加
      addStudent () {
        var self = this;
        this.$axios.post("api/aa/StudentController/addStudent", this.$qs.stringify(this.addStudentForm)).then(function (res) {
          if (res.data.code == 1111) {
            self.$message({showClose: true,message: '添加成功！',type: 'success'});
            self.addStudentForm={};
            self.addbutton=false;
            self.queryStudent();
          }else if(res.data.code == 2222){
            self.$message({showClose: true,message: res.data.message,type: 'error'});
          }
        })
      },
      //删除
      del(row){
        var self = this;
        var studentId = row.studentId;
        this.$confirm('此操作将永久删除该学生, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.$axios.delete("/api/aa/StudentController/deleteStudent?"+this.$qs.stringify({"studentId":studentId})).then(function (res) {
            self.$message({showClose: true,message: '删除成功！',type: 'success'});
            self.queryStudent();
          })
            .catch(function () {
              self.$message({showClose: true,message: '删除失败！请联系系统管理员！',type: 'error'});
            })
        }).catch(() => {
          self.$message({showClose: true,message: '已取消删除',type: 'info'});
        });
      },
      //回显
      hx(row){
          this.updateStudentForm.studentId=row.studentId,
          this.updateStudentForm.studentName=row.studentName,
          this.updateStudentForm.studentSex=row.studentSex,
          this.updateStudentForm.studentAge=row.studentAge,
          this.updateStudentForm.studentBirthday=row.studentBirthday,
          this.updateStudentForm.studentEb=row.studentEb,
          this.updateStudentForm.studentPhone=row.studentPhone,
          this.updateStudentForm.studentPatriarchName=row.studentPatriarchName,
          this.updateStudentForm.studentPatriarchPhone=row.studentPatriarchPhone,
          this.updateStudentForm.homeAddress=row.homeAddress,
          this.updateStudentForm.idNumber=row.idNumber,
          this.updateStudentForm.timesOfRepetition=row.timesOfRepetition,

          this.updatebutton=true;
      },
      // 修改取消
      updateoff(){
        this.updatebutton=false;
      },
      // 修改
      updateStudent () {
        var self = this;
        this.$axios.put("api/aa/StudentController/updateStudent", this.$qs.stringify(this.updateStudentForm)).then(function (res) {
          console.log(res.data)
          if (res.data.code == 1111) {
            self.$message({showClose: true,message: '修改成功！',type: 'success'});
            self.updatebutton=false;
            self.queryStudent();
          }else if(res.data.code == 2222){
            self.$message.error(res.data.message);
          }
        })
      },
      //切换每一页的条数时触发
      handleSizeChange(val) {
        this.paging.pagingSize=(val);
        this.paging.pagingStart=0;
        this.queryStudent();
      },
      //切换第几页时触发
      handleCurrentChange(val) {
        this.paging.pagingStart=(val-1)*this.paging.pagingSize;
        this.queryStudent();
      },
      //当选中复选框时触发该事件
      handleSelectionChange(val) {
        this.multipleSelection = val;
      },

    },
    created(){
      this.queryStudent();
    },

  }
</script>

<style scoped>
  /deep/.el-table th > .cell {
    text-align: center;
  }
  /deep/.el-table .cell {
    text-align: center;
  }
</style>
