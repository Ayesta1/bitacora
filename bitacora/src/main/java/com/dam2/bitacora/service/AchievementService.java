package com.dam2.bitacora.service;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.dam2.bitacora.entity.Achievements;

@Repository
public interface AchievementService {

    public Achievements findById(long id);
    public List<Achievements> findAll();
    public List<Achievements> findByCategoryId(Long categoryid);
}