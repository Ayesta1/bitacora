package com.dam2.bitacora.dao;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dam2.bitacora.entity.Category;

@Repository
public interface CategoryDAO extends JpaRepository <Category, Long> {

    
}
