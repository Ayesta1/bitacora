package com.dam2.bitacora.service;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.dam2.bitacora.entity.Users;

@Repository
public interface UsersService{
    
    public List<Users> findAll();
    
    public Users findById(Long id);

    public void save(Users id);

    public void deleteById(Long id);
    
}
