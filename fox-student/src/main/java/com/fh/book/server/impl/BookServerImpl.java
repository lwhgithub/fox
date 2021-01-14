package com.fh.book.server.impl;

import com.fh.book.mapper.BookMapper;
import com.fh.book.model.Book;
import com.fh.book.model.BookParam;
import com.fh.book.server.BookServer;
import com.fh.common.ServerResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 生产地址: FLYFOX第五号BUG工厂第二分厂三十三号生产员
 * 生产日期: 2021-01-05 11:39
 */
@Service

public class BookServerImpl implements BookServer {
    @Resource
    private BookMapper bookMapper;


    @Override
    public ServerResponse queryBook(BookParam bookParam) {
        if(StringUtils.isNotBlank(bookParam.getBookPeoples())){
            String[] split = bookParam.getBookPeoples().split(",");
            //数组直接转为list
            List<String> ps = Arrays.asList(split);
            bookParam.setPs(ps);
        }
        List<Book> list = bookMapper.queryBook(bookParam);
        long count = bookMapper.queryCount(bookParam);
        HashMap<Object, Object> map = new HashMap<>();
        map.put("list",list);
        map.put("count",count);
        return ServerResponse.success(map);
    }

    @Override
    public ServerResponse addBook(Book book) {
        bookMapper.addBook(book);
        return ServerResponse.success();
    }

    @Override
    public ServerResponse deleteBook(Integer bookId) {
        bookMapper.deleteBook(bookId);
        return ServerResponse.success();
    }

    @Override
    public ServerResponse updateBook(Book book) {
        bookMapper.updateBook(book);
        return ServerResponse.success();
    }


}
