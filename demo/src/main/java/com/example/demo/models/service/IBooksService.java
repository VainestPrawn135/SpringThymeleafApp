package com.example.demo.models.service;

import java.util.List;

import com.example.demo.models.entity.Books;

public interface IBooksService {
    public List<Books> findAll();

    public void save(Books books);

    public void saveAll(List<Books> books);

    public Books findOne(Long Id);

    public void delete(Books books);
}