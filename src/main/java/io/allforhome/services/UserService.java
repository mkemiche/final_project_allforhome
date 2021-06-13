package io.allforhome.services;

import io.allforhome.enums.Role;
import io.allforhome.models.User;
import io.allforhome.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author mkemiche
 * @created 05/06/2021
 */

@Service
public class UserService {


    @Autowired
    UserRepository userRepository;

    public void saveUser(User user){
        user.setURoles(Role.ROLE_PRIVATE_USER.getRole());
        userRepository.save(user);
    }

    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);
    }

    public List<User> getAllUser(){
        return userRepository.findAll();
    }




}
