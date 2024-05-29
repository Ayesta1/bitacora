package com.dam2.bitacora.service;

import org.springframework.stereotype.Repository;

import com.dam2.bitacora.entity.UserAchievements;

@Repository
public interface UserAchievementsService {

    public UserAchievements findById(Long id);

}
