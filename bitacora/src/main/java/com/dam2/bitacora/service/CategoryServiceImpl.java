package com.dam2.bitacora.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dam2.bitacora.dao.CategoryDAO;
import com.dam2.bitacora.entity.Category;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryDAO categoryDAO;

    @Override
    public Category findById(Long id) {
        // TODO Auto-generated method stub
        return categoryDAO.findById(id).orElse(null);
    }

    @Override
    public List<Category> findAll() {
        // TODO Auto-generated method stub
        return categoryDAO.findAll();
    }
}