package com.dam2.bitacora.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dam2.bitacora.entity.Achievements;

@Repository
public interface AchievementsDAO extends JpaRepository <Achievements, Long>{

    // @Query("SELECT a FROM Achievement a WHERE a.category.id = :categoryid")
    // Achievements findByCategoryId(long categoryid);
}
