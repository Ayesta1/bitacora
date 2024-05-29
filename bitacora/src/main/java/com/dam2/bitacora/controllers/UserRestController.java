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
import com.dam2.bitacora.entity.Users;
import com.dam2.bitacora.service.AchievementService;
import com.dam2.bitacora.service.UsersService;
import com.dam2.bitacora.service.CategoryService;

//Indiciamos que es un controlador rest
@RestController
public class UserRestController {
    
    public List<Users> users = new ArrayList<>();
    //Inyectamos el servicio para poder hacer uso de el


    @Autowired
    private UsersService usersService;

    @Autowired
    private AchievementService achievementService;

    @Autowired
    private CategoryService categoryService;
  
    @PostMapping("/users")
    public Users crearUsuario(@RequestBody Users usuario  ) {
        users.add(usuario);
        return usuario;
    }

    @GetMapping("/users")
    public List<Users> findAll() {
        return usersService.findAll();
    }
    // @GetMapping("/users")
    // public List<Users> findAll(){
    //     //retornará todos los usuarios
    //     return usersService.findAll();
    // }

    @GetMapping("/achievements")
    public List<Achievements> findAllAchievements(){
        //retornará todos los usuarios
        return achievementService.findAll();
    }

    @GetMapping("/category")
    public List<Category> findAllCategory(){
        //retornará todos los usuarios
        return categoryService.findAll();
    }

    @GetMapping("/category/{id}")
    public Category getCategory(@PathVariable Long id){
        
        Category category = (Category) categoryService.findById(id);
        return category;
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
                usuario.setContra(usuarioActualizado.getContra());
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

    //QUERY ERROR
    // @GetMapping("/achievements/category/{categoryId}")
    // public Achievements getAchievementsByCategoryId(@PathVariable long categoryid) {
        
    //     return achievementService.getAchievementsByCategoryId(categoryid);
    // }

    @GetMapping("/users/achievements/{id}")
    public Achievements getAchievements(@PathVariable long id){

        Achievements achievements = (Achievements) achievementService.findById(id);

        return achievements;
    }
    
       
    // /*Este método se hará cuando por una petición POST (como indica la anotación) se llame a la url
    // http://127.0.0.1:8080/users  */
    @PostMapping("/users")
    public Users addUser(@RequestBody Users users) {
        users.setId(null);

        //Este metodo guardará al usuario enviado
        usersService.save(users);

        return users;

    }
    // /*Este método se hará cuando por una petición PUT (como indica la anotación) se llame a la url
    // http://127.0.0.1:8080/users  */
    @PutMapping("/users")
    public Users updateUser(@RequestBody Users id) {

        usersService.save(id);

        //este metodo actualizará al usuario enviado

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

        usersService.deleteById(id);

        //Esto método, recibira el id de un usuario por URL y se borrará de la bd.
        return "Deleted user id - "+id;
    }

}
