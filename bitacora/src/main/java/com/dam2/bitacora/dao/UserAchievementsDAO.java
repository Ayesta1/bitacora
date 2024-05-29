package com.dam2.bitacora.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dam2.bitacora.entity.UserAchievements;

@Repository
public interface UserAchievementsDAO extends JpaRepository <UserAchievements, Long>{

}
