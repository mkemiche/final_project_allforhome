package io.allforhome.services;

import io.allforhome.exceptions.UserAlreadyExistsException;
import io.allforhome.exceptions.UserNotFoundException;
import io.allforhome.models.PrivateUser;
import io.allforhome.models.RegistrationDate;
import io.allforhome.models.User;
import io.allforhome.repositories.UserRepository;
import io.allforhome.security.AppSecurityConfig;
import io.allforhome.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * @author mkemiche
 * @created 05/06/2021
 */

@Service
@Transactional
public class UserService {


    @Autowired
    UserRepository userRepository;

    public void saveUser(User user) throws UserAlreadyExistsException{

        if(userRepository.findUserByuEmail(user.getUEmail()).isPresent()){
            throw new UserAlreadyExistsException("This email is already exists in the database. \nInsert another email or reset password.");
        }

        user.setRegistration(new RegistrationDate(LocalDateTime.now()));
        user.setUPassword(AppSecurityConfig.getPasswordEncoder().encode(user.getUPassword()));
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

    public Optional<User> findUserByEmail(String email){
        return userRepository.findUserByuEmail(email);
    }

    public void removeUser(Long id) throws Exception {
        try {
            userRepository.deleteById(id);
        }catch (Exception e){
            throw new Exception("Problem occured while deleting");
        }

    }

    public void updateUser(PrivateUser user) throws Exception {
        if(user == null){
            throw new UserNotFoundException("Requested user not found");
        }
        try{
            userRepository.save(user);
        }catch (Exception e){
            throw new Exception("problem occured while updating");
        }

    }

    public PrivateUser updateUserFields(PrivateUser oldUser, PrivateUser user) {
        oldUser.setUsername(user.getUsername());
        oldUser.setUEmail(user.getUEmail());
        return oldUser;
    }
}
