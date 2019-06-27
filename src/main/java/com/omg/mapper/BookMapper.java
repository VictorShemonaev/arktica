package com.omg.mapper;

import com.omg.entity.Book;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper implements RowMapper<Book> {

    public Book mapRow(ResultSet resultSet, int i) throws SQLException {
        Book book = new Book();
        book.setId(resultSet.getInt("id"));
        book.setBookName(resultSet.getString("bookName"));
        book.setBookTitle(resultSet.getString("bookTitle"));
        book.setBookShortTitle(resultSet.getString("bookShortTitle"));
        book.setBookAuthor(resultSet.getString("bookAuthor"));
        book.setBookPrice(resultSet.getInt("bookPrice"));
        return book;
    }
}
