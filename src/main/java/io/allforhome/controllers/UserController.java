package io.allforhome.controllers;

import io.allforhome.models.*;
import io.allforhome.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author mkemiche
 * @created 11/06/2021
 */

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @ModelAttribute("agent")
    public Agent initAgent(){
        return new Agent();
    }

    @ModelAttribute("agency")
    public RSAgency initCompany(){
        return new RSAgency();
    }

    @ModelAttribute("companyLocation")
    public Location initLocation(){
        return new Location();
    }

    @ModelAttribute("privateuser")
    public PrivateUser initPrivateUser(){
        return new PrivateUser();
    }

    @ModelAttribute("email")
    public String initEmail(){
        return "";
    }

    @ModelAttribute("password")
    public String initPassword(){
        return "";
    }

    @RequestMapping(value = "user/getalluser", method = RequestMethod.GET)
    public String getAllUsers(Model model){
        List<User> users = userService.getAllUser();
        model.addAttribute("users", users);
        return "";
    }

    @RequestMapping(value = "user/reset", method = RequestMethod.GET)
    public String resetPassword(){
        return "user/reset_password";
    }

    @RequestMapping(value = "user/reset", method = RequestMethod.POST)
    public String resetPassword(@RequestParam("email") String email){
        System.out.println("email  " + email);
        return "user/reset_password";
    }

    @RequestMapping(value = "user/login", method = RequestMethod.GET)
    public String loginUser(){
        return "user/login";
    }

    @RequestMapping(value = "user/register", method = RequestMethod.GET)
    public String registerNewUser(){
        return "user/register";
    }

    @RequestMapping(value = "user/register", method = RequestMethod.POST)
    public String registerNewUser(@ModelAttribute("privateuser") PrivateUser privateUser){
        userService.saveUser(privateUser);
        return "redirect:/";
    }

    @RequestMapping(value = "company/register", method = RequestMethod.GET)
    public String registerCompany(){
        return "user/add_agency";
    }


}
