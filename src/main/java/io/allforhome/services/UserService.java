package io.allforhome.services;

import io.allforhome.models.RegistrationDate;
import io.allforhome.models.User;
import io.allforhome.repositories.UserRepository;
import io.allforhome.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

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
        user.setRegistration(new RegistrationDate(LocalDateTime.now()));
        userRepository.save(user);
    }

    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);
    }

    public List<User> getAllUser(){
        return userRepository.findAll();
    }


    public boolean checkValidatePassword(String pass, String cPass, Model model){
        boolean notValid = false;
        if(pass.isBlank()){
            model.addAttribute("emptyPassword", "This field is required");
            notValid = true;
        }
        if(cPass.isBlank()){
            model.addAttribute("emptycPassword", "This field is required");
            notValid = true;
        }
        if(notValid){
            return false;
        }
        if(!Utils.checkPasswordConfirmation(pass, cPass)) {
            model.addAttribute("invalidConfirmation", "Password's confirmation is invalid. Please try again");
            return false;
        }
        return true;
    }
}
