package com.dam2.bitacora.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dam2.bitacora.entity.Achievements;

@Repository
public interface AchievementsDAO extends JpaRepository <Achievements, Long>{

    @Query("SELECT a.title, a.description FROM Achievements a WHERE a.categoryid= :categoryid")
    List<Achievements> findByCategoryId(@Param("categoryid") Long categoryid);
    
}
