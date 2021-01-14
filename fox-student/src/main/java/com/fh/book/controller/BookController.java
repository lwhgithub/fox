package com.fh.book.controller;

import com.fh.book.model.Book;
import com.fh.book.model.BookParam;
import com.fh.book.server.BookServer;
import com.fh.common.ServerResponse;
import org.apache.catalina.Server;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 生产地址: FLYFOX第五号BUG工厂第二分厂三十三号生产员
 * 生产日期: 2021-01-05 12:10
 */
@RestController
@RequestMapping("BookController")
public class BookController {
    @Resource
    private BookServer bookServer;

//   接口作用:       对t_book表的信息进行查询,分页,条件查询
//   请求路径：      http://localhost:8111/aa/BookController/queryBook
//   请求类型：      get
//   接收参数：      com.fh.book.model.BookParam
//   接收数据类型：  com.fh.book.model.BookParam
//   必须参数:       无 默认提供pagingSize=10 pagingStart=0
//   返回值:         {"code":1111,"data":{"count":条数,"list":[{数据1},{数据2},...]},"message":"成功"}
//   返回值类型：    json
    @GetMapping("queryBook")
    public ServerResponse queryBook(BookParam bookParam){
        return bookServer.queryBook(bookParam);
    }

//   接口作用:       对t_book表的信息进行添加
//   请求路径：      http://localhost:8111/aa/BookController/addBook
//   请求类型：      post
//   接收参数：      com.fh.book.model.Book
//   接收数据类型：  com.fh.book.model.Book
//   必须参数:       无
//   返回值:         {"code":1111,"data":null,"message":"成功"}
//   返回值类型：    json
    @PostMapping("addBook")
    public ServerResponse addBook(Book book){
        return bookServer.addBook(book);
    }

//   接口作用:       对t_book表的信息进行删除
//   请求路径：      http://localhost:8111/aa/BookController/deleteBook
//   请求类型：      delete
//   接收参数：      bookId
//   接收数据类型：  Integer
//   必须参数:       bookId
//   返回值:         {"code":1111,"data":null,"message":"成功"}
//   返回值类型：    json
    @DeleteMapping("deleteBook")
    public ServerResponse deleteBook(Integer bookId){
        return bookServer.deleteBook(bookId);
    }

//   接口作用:       对t_book表的信息进行修改
//   请求路径：      http://localhost:8111/aa/BookController/updateBook
//   请求类型：      put
//   接收参数：      com.fh.book.model.Book
//   接收数据类型：  com.fh.book.model.Book
//   必须参数:       Integer类型:bookId;
//   返回值:         {"code":1111,"data":null,"message":"成功"}
//   返回值类型：    json
    @PutMapping("updateBook")
    public ServerResponse updateBook(Book book){
        return bookServer.updateBook(book);
    }


}
