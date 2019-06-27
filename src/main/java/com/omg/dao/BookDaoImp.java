package com.omg.dao;

import com.omg.entity.Book;
import com.omg.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDaoImp implements BookDao{

    @Autowired
    public JdbcTemplate jdbcTemplate;
    public void save(Book book) {
        String sql = "INSERT INTO book (bookName, bookTitle, bookShortTitle, bookAuthor, bookPrice) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, book.getBookName(), book.getBookTitle(), book.getBookShortTitle(), book.getBookAuthor(), book.getBookPrice());
    }

    public Book getById(int id) {
        String sql = "SELECT * FROM book WHERE id=?";
        return jdbcTemplate.queryForObject(sql, new BookMapper(), id);
    }

    public List<Book> findAll() {
        String sql = "SELECT * FROM book";
        return jdbcTemplate.query(sql, new BookMapper());
    }

    public void update(Book book) {
        String sql = "UPDATE book SET bookName = ?, bookTitle = ?, bookShortTitle = ?, bookAuthor = ?, bookPrice = ? WHERE id = ?";
        jdbcTemplate.update(sql, book.getBookName(), book.getBookTitle(), book.getBookShortTitle(), book.getBookAuthor(), book.getBookPrice(), book.getId());
    }

    public void delete(int id) {
        String sql = "DELETE FROM book WHERE id=?";
        jdbcTemplate.update(sql, id);
    }
}
