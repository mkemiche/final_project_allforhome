package io.allforhome.services;

import io.allforhome.models.RegistrationDate;
import io.allforhome.models.User;
import io.allforhome.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
        user.setPUpdateDate(new RegistrationDate(LocalDateTime.now()));
        userRepository.save(user);
    }

    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);
    }

    public List<User> getAllUser(){
        return userRepository.findAll();
    }

}
