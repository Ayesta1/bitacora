package com.dam2.bitacora.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dam2.bitacora.dao.UserAchievementsDAO;
import com.dam2.bitacora.entity.UserAchievements;

@Service
public class UserAchievementServiceImpl implements UserAchievementsService{

    @Autowired
    private UserAchievementsDAO userAchievementsDAO;

    @Override
    public UserAchievements findById(Long id) {
        // TODO Auto-generated method stub
        return userAchievementsDAO.findById(id).orElse(null);
    }

}
