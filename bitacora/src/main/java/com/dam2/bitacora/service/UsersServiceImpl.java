package com.dam2.bitacora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dam2.bitacora.dao.UsersDAO;
import com.dam2.bitacora.entity.Users;


@Service
public class UsersServiceImpl  implements UsersService {

    @Autowired
    private UsersDAO usersDAO; 


    @Override
    public Users findById(Long id) {
        // TODO Auto-generated method stub
       return usersDAO.findById(id).orElse(null);
    }


    @Override
    public List<Users> findAll() {
        // TODO Auto-generated method stub

        return usersDAO.findAll();
    }


    @Override
    public void deleteById(Long id) {

        Users user = usersDAO.findById(id).orElse(null);
        
        if (user != null) {
            usersDAO.delete(user);
        
        return;
        }
    }


    @Override
    public void save(Users user) {
        usersDAO.save(user);
    }

}
