package com.dam2.bitacora.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dam2.bitacora.entity.Achievements;

@Repository
public interface AchievementsDAO extends JpaRepository <Achievements, Long>{

    @Query("SELECT a FROM Achievements a, Category c WHERE c.id= :id AND a.categoryid= :categoryid")
    List<Achievements> findByCategoryId(@Param("id") Long id,@Param("categoryid") Long categoryid);

}
