package com.dam2.bitacora.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dam2.bitacora.dao.UsersDAO;
import com.dam2.bitacora.entity.Users;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersDAO usersDAO;

    @Override
    public List<Users> findAll() {
        return usersDAO.findAll();
    }

    @Override
    public Users findById(Long id) {
        return usersDAO.findById(id).orElse(null);
    }

    @Override
    public Users save(Users user) {
        return usersDAO.save(user);
    }

    @Override
    public void deleteById(Long id) {
        usersDAO.deleteById(id);
    }

    @Override
    public void updateBiography(Long id, String biography) {
        Users user = usersDAO.findById(id).orElse(null);
        if (user != null) {
            user.setBiography(biography);
            usersDAO.save(user);
            System.out.println("Biography updated successfully for user id: " + id);
        } else {
            System.out.println("User with id " + id + " not found");
        }
    }
}
