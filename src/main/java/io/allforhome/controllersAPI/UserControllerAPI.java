package io.allforhome.controllersAPI;


import io.allforhome.exceptions.UserNotFoundException;
import io.allforhome.models.User;
import io.allforhome.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;
import java.util.Optional;

/**
 * @author mkemiche
 * @created 21/06/2021
 */

@RestController
@RequestMapping("api/user")
@EnableWebMvc
public class UserControllerAPI {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/getallusers", produces = "application/json")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUserById(@PathVariable("id") Long id){
        Optional<User> user = userService.getUserById(id);
        if(user.isEmpty()){
            throw new UserNotFoundException("User id: "+id +" not found");
        }
        return user.get();
    }

    @PostMapping("/newuser")
    public void newUser(@RequestBody User user){
        userService.saveUser(user);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable("id") Long id, @RequestBody User user) throws Exception {
        userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) throws Exception {
        userService.removeUser(id);
    }
}
