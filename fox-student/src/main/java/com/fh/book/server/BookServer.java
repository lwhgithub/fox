package com.fh.book.server;

import com.fh.book.model.Book;
import com.fh.book.model.BookParam;
import com.fh.common.ServerResponse;

/**
 * 生产地址: FLYFOX第五号BUG工厂第二分厂三十三号生产员
 * 生产日期: 2021-01-05 11:38
 */
public interface BookServer {
    ServerResponse queryBook(BookParam bookParam);

    ServerResponse addBook(Book book);

    ServerResponse deleteBook(Integer bookId);

    ServerResponse updateBook(Book book);
}
