package com.fh.book.mapper;

import com.fh.book.model.Book;
import com.fh.book.model.BookParam;

import java.util.List;

/**
 * 生产地址: FLYFOX第五号BUG工厂第二分厂三十三号生产员
 * 生产日期: 2021-01-05 11:46
 */
public interface BookMapper {
    List<Book> queryBook(BookParam bookParam);

    long queryCount(BookParam bookParam);

    void addBook(Book book);

    void deleteBook(Integer bookId);

    void updateBook(Book book);
}
