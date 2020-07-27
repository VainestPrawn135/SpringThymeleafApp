package com.example.demo.models.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.example.demo.models.dao.IBooksDao;
import com.example.demo.models.entity.Books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BooksServiceImpl implements IBooksService {

    @Autowired
    private IBooksDao booksDao;

    @Override
    @Transactional(readOnly = true)
    public List<Books> findAll() {
        return (List<Books>) booksDao.findAll();
    }

    @Override
    public void save(Books books) {
        booksDao.save(books);
    }

    @Override
    public void saveAll(List<Books> books) {
        booksDao.saveAll(books);
    }

    @Override
    @Transactional(readOnly = true)
    public Books findOne(Long Id) {
        return booksDao.findById(Id).orElse(null);
    }

    @Override
    public void delete(Books books) {
        booksDao.delete(books);
    }
    
    @Override
    public void delete(Long Id) {
        booksDao.deleteById(Id);
    }
    
}