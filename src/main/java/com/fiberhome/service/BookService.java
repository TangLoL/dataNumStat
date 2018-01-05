package com.fiberhome.service;

import com.fiberhome.entity.Book;

import java.util.List;

/**
 * Created by zyf on 2017/11/30.
 */
public interface BookService {
    public List<Book> findone(String name);
    public List<Book> findAll(Integer one);
}
