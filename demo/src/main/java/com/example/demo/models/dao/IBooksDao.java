package com.example.demo.models.dao;

import com.example.demo.models.entity.Books;

import org.springframework.data.repository.CrudRepository;

public interface IBooksDao extends CrudRepository<Books, Long> {
    
}