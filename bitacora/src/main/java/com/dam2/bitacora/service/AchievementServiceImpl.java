package com.dam2.bitacora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dam2.bitacora.dao.AchievementsDAO;
import com.dam2.bitacora.entity.Achievements;

@Service
public class AchievementServiceImpl implements AchievementService {

    @Autowired
    private AchievementsDAO achievementsDAO;

    
    @Override
    public Achievements findById(long id) {
        // TODO Auto-generated method stub
        return achievementsDAO.findById(id).orElse(null);
    }

    
    @Override
    public List<Achievements> findAll() {

        return achievementsDAO.findAll();
    }


    @Override
    public List<Achievements> findByCategoryId(Long categoryid) {
        
        return achievementsDAO.findByCategoryId(null, null);
    }


    
    // QUERY ERROR
    // @Override
    // public Achievements getAchievementsByCategoryId(long categoryid) {
    //     // TODO Auto-generated method stub
    //     return achievementsDAO.findByCategoryId(categoryid);
    // }


   
}
