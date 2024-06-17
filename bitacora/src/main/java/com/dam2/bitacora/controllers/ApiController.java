package com.dam2.bitacora.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dam2.bitacora.entity.Achievements;
import com.dam2.bitacora.entity.Category;
import com.dam2.bitacora.entity.Userachievements;
import com.dam2.bitacora.entity.Users;
import com.dam2.bitacora.service.AchievementService;
import com.dam2.bitacora.service.UsersService;
import com.dam2.bitacora.service.CategoryService;
import com.dam2.bitacora.service.UserAchievementsService;

@RestController
public class ApiController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private AchievementService achievementService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private UserAchievementsService userAchievementsService;

    @GetMapping("/users")
    public List<Users> findAllUsers() {
        return usersService.findAll();
    }

    @GetMapping("/achievements")
    public List<Achievements> findAllAchievements() {
        return achievementService.findAll();
    }

    @GetMapping("/category")
    public List<Category> findAllCategories() {
        return categoryService.findAll();
    }

    @GetMapping("/userachievements")
    public List<Userachievements> findAllUserAchievements() {
        return userAchievementsService.findAll();
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public Users createUser(@RequestBody Users newUser) {
        return usersService.save(newUser);
    }
    
    @GetMapping("/userachievements/{id}")
    public ResponseEntity<Userachievements> findUserAchievementById(@PathVariable Long id) {
        Userachievements userachievement = userAchievementsService.findById(id);
        if (userachievement == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userachievement);
    }

    @PutMapping("/userachievements/{id}")
    public ResponseEntity<Userachievements> updateUserAchievement(@PathVariable Long id, @RequestBody Userachievements updatedUserAchievement) {
        Userachievements existingUserAchievement = userAchievementsService.findById(id);
        if (existingUserAchievement == null) {
            return ResponseEntity.notFound().build();
        }
        
        existingUserAchievement.setAchievementid(updatedUserAchievement.getAchievementid());
        existingUserAchievement.setUserid(updatedUserAchievement.getUserid());
        existingUserAchievement.setPhotoproof(updatedUserAchievement.getPhotoproof());
        existingUserAchievement.setCompletationdate(updatedUserAchievement.getCompletationdate());
        existingUserAchievement.setLike(updatedUserAchievement.getLike());
        existingUserAchievement.setDislike(updatedUserAchievement.getDislike());

        userAchievementsService.save(existingUserAchievement);
        
        return ResponseEntity.ok(existingUserAchievement);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        Users user = usersService.findById(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        usersService.deleteById(id);

        return ResponseEntity.ok("Deleted user id - " + id);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Users> findUserById(@PathVariable Long id) {
        Users user = usersService.findById(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable Long id, @RequestBody Users updatedUser) {
        Users existingUser = usersService.findById(id);
        if (existingUser == null) {
            return ResponseEntity.notFound().build();
        }
        
        existingUser.setUsername(updatedUser.getUsername());
        existingUser.setBirthday(updatedUser.getBirthday());
        existingUser.setMail(updatedUser.getMail());
        existingUser.setPassword(updatedUser.getPassword());
        existingUser.setProfilePhoto(updatedUser.getProfilePhoto());

        usersService.save(existingUser);
        
        return ResponseEntity.ok(existingUser);
    }
    
    @PutMapping("/users/{id}/biography")
    public ResponseEntity<Users> updateBiography(@PathVariable Long id, @RequestBody Users updatedUser) {
        System.out.println("Received request to update biography for user id: " + id);
        Users existingUser = usersService.findById(id);
        if (existingUser == null) {
            return ResponseEntity.notFound().build();
        }
        
        existingUser.setBiography(updatedUser.getBiography());

        usersService.save(existingUser);
        
        return ResponseEntity.ok(existingUser);
    }

    @GetMapping("/category/{categoryid}")
    public ResponseEntity<List<Achievements>> findByCategoryId(@PathVariable Long categoryid) {
        List<Achievements> achievements = achievementService.findByCategoryId(categoryid);
        if (achievements.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(achievements);
    }

    @GetMapping("/users/achievements/{id}")
    public ResponseEntity<Achievements> getAchievementsById(@PathVariable long id) {
        Achievements achievements = achievementService.findById(id);
        if (achievements == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(achievements);
    }
}