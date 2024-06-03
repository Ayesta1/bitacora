package com.dam2.bitacora.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dam2.bitacora.dao.UserAchievementsDAO;
import com.dam2.bitacora.entity.Userachievements;

@Service
public class UserAchievementServiceImpl implements UserAchievementsService{

    @Autowired
    private UserAchievementsDAO userAchievementsDAO;

    @Override
    public Userachievements findById(Long id) {
        // TODO Auto-generated method stub
        return userAchievementsDAO.findById(id).orElse(null);
    }

    @Override
    public List<Userachievements> findAll() {
        // TODO Auto-generated method stub
        return userAchievementsDAO.findAll();
    }

    @Override
    public void save(Userachievements userachievements) {

        userAchievementsDAO.save(userachievements);
    }

    @Override
    public void deleteById(Long id) {
        Userachievements userachievements = userAchievementsDAO.findById(id).orElse(null);
        
        if (userachievements != null) {
            userAchievementsDAO.delete(userachievements);
        
        return;
        }
    }

}
