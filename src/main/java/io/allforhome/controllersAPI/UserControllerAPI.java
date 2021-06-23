package io.allforhome.controllersAPI;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.allforhome.enums.Role;
import io.allforhome.exceptions.UserNotFoundException;
import io.allforhome.models.Agent;
import io.allforhome.models.PrivateUser;
import io.allforhome.models.User;
import io.allforhome.services.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author mkemiche
 * @created 21/06/2021
 */
@RestController
@Api(value="API describe CRUD operation for user object")
@RequestMapping("api/user")
public class UserControllerAPI {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "Return all users existing in the database")
    @GetMapping(value = "/getallusers", produces = "application/json")
    public List<User> getAllUsers(){
        return userService.getAllUser();
    }

    @ApiOperation(value = "Return user by its id if exists")
    @GetMapping(value = "/{id}")
    public User getUserById(@PathVariable("id") Long id){
        Optional<User> user = userService.getUserById(id);
        if(user.isEmpty()){
            throw new UserNotFoundException("User id: "+id +" not found");
        }
        return user.get();
    }

    @ApiOperation(value = "Register new user")
    @PostMapping("/newuser")
    public PrivateUser newUser(@RequestBody PrivateUser user){
        user.setURoles(Role.ROLE_PRIVATE_USER.getRole());
        userService.saveUser(user);

        return user;

    }

    @PostMapping("/newagent")
    public Agent newAgent(@RequestBody User user) throws JsonProcessingException {
        Agent agent = (Agent) user;
        agent.setURoles(Role.ROLE_AGENT_USER.getRole());
        userService.saveUser(agent);
        return agent;
    }

    @ApiOperation(value = "Update user by its id if exists")
    @PutMapping("/{id}")
    public String updateUser(@PathVariable("id") Long id, @RequestBody PrivateUser user) throws Exception {

        PrivateUser oldUser = (PrivateUser) userService.getUserById(id).get();
        var newUser = userService.updateUserFields(oldUser, user);
        userService.updateUser(newUser);

        return new ObjectMapper().writeValueAsString(newUser);
    }

    @ApiOperation(value = "Remove property by its id if exists")
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long id) throws Exception {
        userService.removeUser(id);
        return new ObjectMapper().writeValueAsString("user id: "+id+" deleted");
    }
}
