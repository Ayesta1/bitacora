package com.dam2.bitacora.service;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.dam2.bitacora.entity.Category;

@Repository
public interface CategoryService {

    public Category findById(Long id);

    public List<Category> findAll();

}