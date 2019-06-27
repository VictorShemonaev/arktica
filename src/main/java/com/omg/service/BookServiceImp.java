package com.omg.service;


import com.omg.dao.BookDao;
import com.omg.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImp implements BookService {
    @Autowired
    private BookDao bookDao;
    public List<Book> findAll() {
        return bookDao.findAll();
    }

    public void save(Book book) throws Exception {
        bookDao.save(book);
    }

    public Book getById(int id) {
        return bookDao.getById(id);
    }

    public void update(Book book) {
        bookDao.update(book);
    }

    public void delete(int id) {
        bookDao.delete(id);
    }
}
