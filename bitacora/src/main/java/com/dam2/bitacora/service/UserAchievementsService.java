package com.dam2.bitacora.service;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.dam2.bitacora.entity.Userachievements;

@Repository
public interface UserAchievementsService {

    public Userachievements findById(Long id);

    public List<Userachievements> findAll();

    public void save(Userachievements id);

    public void deleteById(Long id);

}