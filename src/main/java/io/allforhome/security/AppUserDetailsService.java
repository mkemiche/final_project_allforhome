package io.allforhome.security;

import io.allforhome.exceptions.UserNotFoundException;
import io.allforhome.models.User;
import io.allforhome.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author mkemiche
 * @created 21/06/2021
 */

@Service
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String s) throws UserNotFoundException {
        Optional<User> user = userRepository.findUserByuEmail(s);
        if(user.isEmpty()){
            throw new UserNotFoundException("Email does not found in the database");
        }


        List<String> roleList = Arrays.asList(user.get().getURoles().split(","));

       // log.severe("roles : "+roleList);

        return new AppUserDetails(user.get(), roleList);
    }
}
