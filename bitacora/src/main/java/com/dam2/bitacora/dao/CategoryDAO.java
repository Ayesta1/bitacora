package com.dam2.bitacora.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dam2.bitacora.entity.Category;

@Repository
public interface CategoryDAO extends JpaRepository <Category, Long> {

}