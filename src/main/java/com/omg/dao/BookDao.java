package com.omg.dao;

import com.omg.entity.Book;

import java.util.List;

public interface BookDao {
    void save(Book book);

    Book getById(int id);

    List<Book> findAll();

    void update(Book book);

    void delete(int id);
}
