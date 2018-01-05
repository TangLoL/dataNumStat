package com.fiberhome.service;

import com.fiberhome.mapper.BookDao;
import com.fiberhome.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zyf on 2017/11/30.
 */
@Service
public class BookServiceImp implements BookService{
    @Autowired
    private BookDao bookDao;

    @Override
    public List<Book> findone(String name) {
        return null;
    }

    @Override
    public List<Book> findAll(Integer one) {
        return null;
    }
}
