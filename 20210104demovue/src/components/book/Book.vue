<template>
    <div>
      <!--  条件查询-->
      <el-form  :inline="true" v-model="paging" ref="queryform" >
        <el-form-item label="名称" >
          <el-input v-model="paging.bookName"></el-input>
        </el-form-item>
        <el-form-item label="价格">
          <el-col :span="9">
            <el-input placeholder="最低价格" v-model="paging.bookPriceMin" style="width: 100%;"></el-input>
          </el-col>
          <el-col class="line" :span="2">---</el-col>
          <el-col :span="9">
            <el-input placeholder="最高价格" v-model="paging.bookPriceMax" style="width: 100%;"></el-input>
          </el-col>
        </el-form-item>
        <el-form-item label="销售地区" >
          <el-select v-model="paging.bookArea" placeholder="请选择" style="width: 200px">
            <el-option :label="area.name"  :value="area.id" v-for="(area,index) in areas" :key="index"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="类型">
          <el-radio v-model="paging.bookType" :label="1">电子书</el-radio>
          <el-radio v-model="paging.bookType" :label="2">实体书</el-radio>
        </el-form-item>
        <el-form-item label="适合人群">
          <div align="left">
            <el-checkbox-group v-model="bookPeoples">
              <el-checkbox label="1" value="1">少年</el-checkbox>
              <el-checkbox label="2" value="2">青年</el-checkbox>
              <el-checkbox label="3" value="3">中年</el-checkbox>
              <el-checkbox label="4" value="4">老年</el-checkbox>
            </el-checkbox-group>
          </div>
        </el-form-item>
        <el-form-item label="出版时间">
          <el-col :span="9">
            <el-date-picker type="date" placeholder="选择最早时间" value-format="yyyy-MM-dd" v-model="paging.bookCreateDateMin" style="width: 100%;"></el-date-picker>
          </el-col>
          <el-col class="line" :span="2">---</el-col>
          <el-col :span="9">
            <el-date-picker type="date" placeholder="选择最近时间" value-format="yyyy-MM-dd" v-model="paging.bookCreateDateMax" style="width: 100%;"></el-date-picker>
          </el-col>
        </el-form-item>
        <el-form-item>
          <el-button @click="tjcxcz()">重置</el-button>
          <el-button type="primary" @click="tjcx()">查询</el-button>
        </el-form-item>
      </el-form>
      <!--  添加按钮-->
      <div style="float: right">
        <el-button type="success" @click="addbutton = true" plain>添加</el-button>
      </div>
      <!--  分页-->
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
      <!--  查询展示-->
      <el-table :data="book" border style="width: 100%" @selection-change="handleSelectionChange" >
        <el-table-column type="selection" width="50"></el-table-column>
        <el-table-column label="展示序号" width="80" >
          <template slot-scope="scope">
            {{ scope.$index+1}}
          </template>
        </el-table-column>
        <!--    fixed    固定为第一列-->
        <el-table-column prop="bookName" label="名称" > </el-table-column>
        <el-table-column prop="bookPrice" label="价格(元)" > </el-table-column>
        <el-table-column label="适合人群">
          <template slot-scope="scope">
            {{ scope.row.bookPeoples==null?null:(scope.row.bookPeoples.replace('1','少年').replace('2','青年').replace('3','中年').replace('4','老年'))}}
          </template>
        </el-table-column>
        <el-table-column prop="bookType" label="类型" >
          <template slot-scope="scope">
            {{ scope.row.bookType==1?'电子书':scope.row.bookType==2?'实体书':'待定'}}
          </template>
        </el-table-column>
        <el-table-column prop="bookCreateDate" label="出版时间"></el-table-column>
        <el-table-column prop="bookArea" label="销售地区" >
          <template slot-scope="scope">
            {{ scope.row.bookArea==1?'北京':scope.row.bookArea==2?'上海':scope.row.bookArea==3?'广州':scope.row.bookArea==4?'深圳':'待定'}}
          </template>
        </el-table-column>
        <el-table-column label="操作">
          <template slot-scope="scope">
            <el-row>
              <el-button type="primary" icon="el-icon-edit" @click="hx(scope.row)" circle></el-button>
              <el-button type="danger" icon="el-icon-delete" @click="del(scope.row)" circle></el-button>
            </el-row>
          </template>
        </el-table-column>
      </el-table>
      <!--  添加-->
      <el-dialog title="添加" :visible.sync="addbutton">
        <!--      表单部分-->
        <el-form :model="addBookForm" ref="addBookForm" >
          <el-form-item label="名称" :label-width="formLabelWidth">
            <el-input v-model="addBookForm.bookName" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="价格" :label-width="formLabelWidth">
            <el-input v-model="addBookForm.bookPrice" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="适合人群" :label-width="formLabelWidth" prop="bookPeoples">
            <div align="left">
              <el-checkbox-group v-model="addBookForm.bookPeoples">
                <el-checkbox label="1" value="1">少年</el-checkbox>
                <el-checkbox label="2" value="2">青年</el-checkbox>
                <el-checkbox label="3" value="3">中年</el-checkbox>
                <el-checkbox label="4" value="4">老年</el-checkbox>
              </el-checkbox-group>
            </div>
          </el-form-item>
          <el-form-item label="类型" :label-width="formLabelWidth">
            <div align="left">
              <el-radio v-model="addBookForm.bookType" :label="1" >电子书</el-radio>
              <el-radio v-model="addBookForm.bookType" :label="2" >实体书</el-radio>
            </div>
          </el-form-item>
          <el-form-item label="出版时间" :label-width="formLabelWidth">
            <div align="left">
              <el-date-picker v-model="addBookForm.bookCreateDate" type="date" value-format="yyyy-MM-dd" placeholder="选择日期" style="width: 300px"></el-date-picker>
            </div>
          </el-form-item>
          <el-form-item label="销售地区" :label-width="formLabelWidth" prop="bookArea">
            <div align="left">
              <el-select v-model="addBookForm.bookArea" placeholder="请选择" style="width: 300px">
                <el-option :label="area.name"  :value="area.id" v-for="(area,index) in areas" :key="index"></el-option>
              </el-select>
            </div>
          </el-form-item>
        </el-form>
        <!--      按钮部分-->
        <div slot="footer" class="dialog-footer">
          <el-button @click="addoff()">取 消</el-button>
          <el-button type="primary" @click="addBook()">确 定</el-button>
        </div>
      </el-dialog>
      <!--  修改-->
      <el-dialog title="修改" :visible.sync="updatebutton">
        <!--      表单部分-->
        <el-form :model="updateBookForm" ref="updateBookForm" >
          <el-form-item label="名称" :label-width="formLabelWidth">
            <el-input v-model="updateBookForm.bookName" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="价格" :label-width="formLabelWidth">
            <el-input v-model="updateBookForm.bookPrice" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="适合人群" :label-width="formLabelWidth" prop="bookPeoples">
            <div align="left">
              <el-checkbox-group v-model="updateBookForm.bookPeoples">
                <el-checkbox label="1" value="1">少年</el-checkbox>
                <el-checkbox label="2" value="2">青年</el-checkbox>
                <el-checkbox label="3" value="3">中年</el-checkbox>
                <el-checkbox label="4" value="4">老年</el-checkbox>
              </el-checkbox-group>
            </div>
          </el-form-item>
          <el-form-item label="类型" :label-width="formLabelWidth">
            <div align="left">
              <el-radio v-model="updateBookForm.bookType" :label="1" >电子书</el-radio>
              <el-radio v-model="updateBookForm.bookType" :label="2" >实体书</el-radio>
            </div>
          </el-form-item>
          <el-form-item label="出版时间" :label-width="formLabelWidth">
            <div align="left">
              <el-date-picker v-model="updateBookForm.bookCreateDate" type="date" value-format="yyyy-MM-dd" placeholder="选择日期" style="width: 300px"></el-date-picker>
            </div>
          </el-form-item>
          <el-form-item label="销售地区" :label-width="formLabelWidth" prop="bookArea">
            <div align="left">
              <el-select v-model="updateBookForm.bookArea" placeholder="请选择" style="width: 300px">
                <el-option :label="area.name"  :value="area.id" v-for="(area,index) in areas" :key="index"></el-option>
              </el-select>
            </div>
          </el-form-item>
        </el-form>
        <!--      按钮部分-->
        <div slot="footer" class="dialog-footer">
          <el-button @click="updateoff()">取 消</el-button>
          <el-button type="primary" @click="updateBook()">确 定</el-button>
        </div>
      </el-dialog>
    </div>
</template>

<script>
  export default {
    name: '',
    data(){
      return {
        // 销售地区的数组
        areas:[
          {name:"北京",id:1},
          {name:"上海",id:2},
          {name:"广州",id:3},
          {name:"深圳",id:4}
        ],
        // 控制修改的表单
        updatebutton:false,
        // 修改表单数据
        updateBookForm:{
          bookId:'',
          bookName:'',
          bookPrice:'',
          bookType:'',
          bookCreateDate:'',
          bookArea:'',
          bookPeoples:[],
        },
        // 控制添加的表单
        addbutton:false,
        // 添加表单数据
        addBookForm:{
          bookName:'',
          bookPrice:'',
          bookType:'',
          bookCreateDate:'',
          bookArea:'',
          bookPeoples:[],
        },
        // 头部复选框
        multipleSelection:[],
        // 查询结果
        book:[],
        //分页条件查询
        currentPage4: 0,
        total:0,
        xsts:[3,4,5,6,7,8,9,10],
        paging:{
          pagingStart:0,
          pagingSize:3,
          bookName:'',
          bookPriceMin:'',
          bookPriceMax:'',
          bookArea:'',
          bookType:'',
          bookPeoples:[],
          bookCreateDateMin:'',
          bookCreateDateMax:'',
        },
        bookPeoples:[],
        //宽度
        formLabelWidth: '120px',
      }
    },
    methods:{
      // 条件查询重置
      tjcxcz(){
        var pagingsize= this.paging.pagingSize;
        this.paging={};
        this.bookPeoples=[];
        this.paging.bookPeoples=[];
        this.paging.bookPeoples = JSON.parse(JSON.stringify(this.paging.bookPeoples));
        this.paging.pagingStart=0;
        this.paging.pagingSize=pagingsize;
        this.queryBook();
      },
      // 条件查询
      tjcx(){
        this.paging.bookPeoples=this.bookPeoples.toString();
        this.paging.bookPeoples = JSON.parse(JSON.stringify(this.paging.bookPeoples));
        this.paging.pagingStart=0;
        this.queryBook();
      },
      // 查询学生信息
      queryBook () {
        this.paging.bookPeoples = this.paging.bookPeoples.toString();
        var self = this;
        this.$axios.get("api/aa/BookController/queryBook?"+this.$qs.stringify(this.paging)).then(function (res) {
          if (res.data.code == 1111) {
            self.book=res.data.data.list;
            self.total=res.data.data.count;
          }
        })
      },
      // 添加取消
      addoff(){
        this.addBookForm={};
        this.addBookForm.bookPeoples=[];
        this.addBookForm = JSON.parse(JSON.stringify(this.addBookForm));
        this.addbutton=false;
      },
      // 添加
      addBook () {
        this.addBookForm.bookPeoples = this.addBookForm.bookPeoples.toString();
        var self = this;
        this.$axios.post("api/aa/BookController/addBook", this.$qs.stringify(this.addBookForm)).then(function (res) {
          if (res.data.code == 1111) {
            self.$message({showClose: true,message: '添加成功！',type: 'success'});
            self.addBookForm={};
            self.addBookForm.bookPeoples=[];
            self.addBookForm = JSON.parse(JSON.stringify(self.addBookForm));
            self.addbutton=false;
            self.queryBook();
          }else if(res.data.code == 2222){
            self.$message.error(res.data.message);
          }
        })
      },
      // 删除
      del(row){
        var self = this;
        var bookId = row.bookId;
        this.$confirm('此操作将永久删除该book, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.$axios.delete("/api/aa/BookController/deleteBook?"+this.$qs.stringify({"bookId":bookId})).then(function (res) {
            self.$message({showClose: true,message: '删除成功！',type: 'success'});
            self.queryBook();
          }).catch(function () {
              self.$message({showClose: true,message: '删除失败！请联系系统管理员！',type: 'error'});
            })
        }).catch(() => {
          self.$message({showClose: true,message: '已取消删除',type: 'info'});
        });
      },
      // 修改回显
      hx(row){
        this.updateBookForm = JSON.parse(JSON.stringify(row));
        this.updateBookForm.bookId=row.bookId;
        this.updateBookForm.bookName=row.bookName;
        this.updateBookForm.bookPrice=row.bookPrice;
        this.updateBookForm.bookType=row.bookType;
        this.updateBookForm.bookCreateDate=row.bookCreateDate;
        this.updateBookForm.bookArea=row.bookArea;
        this.updateBookForm.bookPeoples=row.bookPeoples.split(",");
        this.updatebutton=true;
      },
      // 修改取消
      updateoff(){
        this.updatebutton=false;
      },
      // 修改
      updateBook(){
        this.updateBookForm.bookPeoples = this.updateBookForm.bookPeoples.toString();
        var self = this;
        this.$axios.put("api/aa/BookController/updateBook", this.$qs.stringify(this.updateBookForm)).then(function (res) {
          if (res.data.code == 1111) {
            self.$message({showClose: true,message: '修改成功！',type: 'success'});
            self.updateBookForm={};
            self.updateBookForm.bookPeoples=[];
            self.updatebutton=false;
            self.queryBook();
          }else if(res.data.code == 2222){
            self.$message.error(res.data.message);
          }
        })
      },
      //切换每一页的条数时触发
      handleSizeChange(val) {
        this.paging.pagingSize=(val);
        this.paging.pagingStart=0;
        this.queryBook();
      },
      //切换第几页时触发
      handleCurrentChange(val) {
        this.paging.pagingStart=(val-1)*this.paging.pagingSize;
        this.queryBook();
      },
      //当选中复选框时触发该事件
      handleSelectionChange(val) {
        this.multipleSelection = val;
      },
    },
      created(){
        this.queryBook();
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
