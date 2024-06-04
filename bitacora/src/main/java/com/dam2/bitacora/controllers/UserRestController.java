package com.dam2.bitacora.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dam2.bitacora.entity.Achievements;
import com.dam2.bitacora.entity.Category;
import com.dam2.bitacora.entity.Userachievements;
import com.dam2.bitacora.entity.Users;
import com.dam2.bitacora.service.AchievementService;
import com.dam2.bitacora.service.UsersService;
import com.dam2.bitacora.service.CategoryService;
import com.dam2.bitacora.service.UserAchievementsService;

//Indiciamos que es un controlador rest
@RestController
public class UserRestController {
    
    public List<Users> users = new ArrayList<>(); //Inyectamos el servicio para poder hacer uso de el

    public List<Userachievements> userachievement = new ArrayList<>();

    @Autowired
    private UsersService usersService;

    @Autowired
    private AchievementService achievementService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private UserAchievementsService userAchievementsService;
  
    @PostMapping("/users")
    public Users crearUsuario(@RequestBody Users usuario  ) {
        users.add(usuario);
        return usuario;
    }

    @GetMapping("/users")
    public List<Users> findAll() {
        return usersService.findAll();
    }

    @GetMapping("/achievements")
    public List<Achievements> findAllAchievements(){ //retornará todos los usuarios
        return achievementService.findAll();
    }

    @GetMapping("/category")
    public List<Category> findAllCategory(){ //retornará todos los usuarios
        return categoryService.findAll();
    }
    
    @GetMapping("/userachievement")
    public List <Userachievements> findAllUserachievements(){
        return userAchievementsService.findAll();
    }

    @PutMapping("/userachievement")
    public Userachievements updateUserAchievement(@RequestBody Userachievements id) { //este metodo actualizará al usuario enviado
        userAchievementsService.save(id);
        return id;
    }

    @GetMapping("/userachievement/{id}")
    public Userachievements obtenerUserAchievements(@PathVariable Long id) {
        Optional<Userachievements> userachievements = userachievement.stream().filter(a -> a.getId()==(id)).findFirst();
        return userachievements.orElse(null);
    }

    @PutMapping("/userachievement/{id}")
    public Userachievements actualizarUserAchievement(@PathVariable Long id, @RequestBody Userachievements userachievementsActualizado) {
        for (Userachievements userachievements : userachievement) {
            if (userachievements.getId()==(id)) {
                userachievements.setAchievementid(userachievementsActualizado.getAchievementid());
                userachievements.setUserid(userachievementsActualizado.getUserid());
                userachievements.setPhotoproof(userachievementsActualizado.getPhotoproof());
                userachievements.setCompletationdate(userachievementsActualizado.getCompletationdate());
                userachievements.setLike(userachievementsActualizado.getLike());
                userachievements.setDislike(userachievementsActualizado.getDislike());
                return userachievements;
            }
        }
        return null;
    }

    @DeleteMapping("/userachievement/{id}")
    public String deteteUserAchievement(@PathVariable Long id) {

        Userachievements userachievements = userAchievementsService.findById(id);

        if(userachievements == null) {
            throw new RuntimeException("Userachievement id not found -"+id);
        }

        userAchievementsService.deleteById(id);

        //Esto método, recibira el id de un usuario por URL y se borrará de la bd.
        return "Deleted userachievement id - "+id;
    }

    /*Este método se hará cuando por una petición GET (como indica la anotación) se llame a la url + el id de un usuario
    http://127.0.0.1:8080/users/1 */
    @GetMapping("/users/{id}")
    public Users obtenerUsuario(@PathVariable Long id) {
        Optional<Users> usuario = users.stream().filter(u -> u.getId()==(id)).findFirst();
        return usuario.orElse(null);
    }

    @PutMapping("/users/{id}")
    public Users actualizarUsuario(@PathVariable Long id, @RequestBody Users usuarioActualizado) {
        for (Users usuario : users) {
            if (usuario.getId()==(id)) {
                usuario.setUsername(usuarioActualizado.getUsername());
                usuario.setBirthday(usuarioActualizado.getBirthday());
                usuario.setMail(usuarioActualizado.getMail());
                usuario.setPassword(usuarioActualizado.getPassword());
                usuario.setProfilePhoto(usuarioActualizado.getProfilePhoto());
                return usuario;
            }
        }
        return null;
    }
    // @GetMapping("/users/{userId}")
    // public Users getUser(@PathVariable long userId){
    //     Users users = usersService.findById(userId);
    //     if(users == null) {
    //         throw new RuntimeException("User id not found -"+userId);
    //     }
    //     //retornará al usuario con id pasado en la url
    //     return users;
    // }

    @GetMapping("/category/{categoryid}")
    public List<Achievements> findByCategoryId(@PathVariable Long categoryid) {

        switch (categoryid.intValue()) {
            
            case 1:
                return achievementService.findByCategoryId(1L);
            case 2:
                return achievementService.findByCategoryId(2L);   
            case 3:
                return achievementService.findByCategoryId(3L);
            case 4:
                return achievementService.findByCategoryId(4L);
            case 5:
                return achievementService.findByCategoryId(5L);
            case 6:
                return achievementService.findByCategoryId(6L);
            default:
                throw new IllegalArgumentException("Invalid category id: " + categoryid);
        }
    }

    @GetMapping("/users/achievements/{id}")
    public Achievements getAchievements(@PathVariable long id){
        Achievements achievements = (Achievements) achievementService.findById(id);
        return achievements;
    }
       
    // /*Este método se hará cuando por una petición POST (como indica la anotación) se llame a la url
    // http://127.0.0.1:8080/users  */
    // @PostMapping("/users")
    // public Users addUser(@RequestBody Users users) {
    //     users.setId(null);
    //     //Este metodo guardará al usuario enviado
    //     usersService.save(users);
    //     return users;
    // }

    // /*Este método se hará cuando por una petición PUT (como indica la anotación) se llame a la url
    // http://127.0.0.1:8080/users  */
    @PutMapping("/users")
    public Users updateUser(@RequestBody Users id) {
        usersService.save(id); //Este metodo actualizará al usuario enviado
        return id;
    }

    // /*Este método se hará cuando por una petición DELETE (como indica la anotación) se llame a la url + id del usuario
    // http://127.0.0.1:8080/users/1  */
    @DeleteMapping("users/{userId}")
    public String deteteUser(@PathVariable Long id) {
        Users user = usersService.findById(id);
        if(user == null) {
            throw new RuntimeException("User id not found -"+id);
        }

        usersService.deleteById(id); //Este método recibira el id de un usuario por URL y se borrará de la bd.
        return "Deleted user id - "+id;
    }
}