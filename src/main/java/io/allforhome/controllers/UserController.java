package io.allforhome.controllers;

import io.allforhome.enums.Role;
import io.allforhome.models.*;
import io.allforhome.services.CompanyService;
import io.allforhome.services.UserService;
import io.allforhome.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * @author mkemiche
 * @created 11/06/2021
 */

@Controller
public class UserController {


    private UserService userService;
    private CompanyService companyService;

    @Autowired
    public UserController(UserService userService, CompanyService companyService) {
        this.userService = userService;
        this.companyService = companyService;
    }

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

    @ModelAttribute("username")
    public String initUsername(){
        return "";
    }

    @ModelAttribute("email")
    public String initEmail(){
        return "";
    }

    @ModelAttribute("password")
    public String initPassword(){
        return "";
    }

    @ModelAttribute("cpassword")
    public String initcPassword(){
        return "";
    }

    @ModelAttribute("emptyPassword")
    public String initemptyPassword(){
        return "";
    }

    @ModelAttribute("emptycPassword")
    public String initemptycPassword(){
        return "";
    }

    @ModelAttribute("invalidConfirmation")
    public String initinvalidConfirmation(){
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
    public String resetPassword(@RequestParam("email") @Valid String email){
        System.out.println("email  " + email);
        return "user/reset_password";
    }

    @RequestMapping(value = "user/resetuserpassword", method = RequestMethod.POST)
    public String userConnectedResetPassword(@RequestParam("password") @Valid String password,
                                             @RequestParam("cpassword") String cPassword, Model model){


        boolean isValid = userService.checkValidatePassword(password, cPassword, model);

        if(!isValid){
            return "user/register";
        }
        System.out.println("email  " + password);
        return "user/reset_password";
    }

    @RequestMapping(value = "user/login", method = RequestMethod.GET)
    public String loginUser(){
        return "user/login";
    }

    @RequestMapping(value = "user/register", method = RequestMethod.GET)
    public String registerNewUser(Model model){
        return "user/register";
    }

    @RequestMapping(value = "user/register", method = RequestMethod.POST)
    public String registerNewUser(@ModelAttribute("privateuser") @Valid PrivateUser privateUser,  BindingResult result,
                                  @RequestParam("cpassword") String cPassword, Model model){

        if(result.hasErrors()){
            if(cPassword.isBlank()){
                model.addAttribute("emptyPassword", "This field is required");
            }
            return "user/register";
        }

        if(cPassword.isBlank()){
            model.addAttribute("invalidConfirmation", "Password's confirmation is failed. Please try again");
            return "user/register";
        }

        boolean isValid = Utils.checkPasswordConfirmation(privateUser.getUPassword(), cPassword);
        if(!isValid){
            model.addAttribute("invalidConfirmation", "Password's confirmation is invalid. Please try again");
            return "user/register";
        }
        //setRole
        privateUser.setURoles(Role.ROLE_PRIVATE_USER.getRole());
        userService.saveUser(privateUser);
        return "redirect:/";
    }

    @RequestMapping(value = "company/register", method = RequestMethod.GET)
    public String registerCompany(){
        return "user/add_agency";
    }

    @RequestMapping(value = "company/register", method = RequestMethod.POST)
    public String registerCompany(@ModelAttribute("agency") @Valid RSAgency agency,
                                  BindingResult res,
                                  @ModelAttribute("agent") @Valid Agent agent,
                                  BindingResult result,
                                  @RequestParam("cpassword") String cPassword,
                                  Model model){


        if(result.hasErrors() || res.hasErrors()){
            if(cPassword.isBlank()){
                model.addAttribute("emptyPassword", "This field is required");
            }
            return "user/add_agency";
        }

        if(cPassword.isBlank()){
            model.addAttribute("invalidConfirmation", "Password's confirmation is failed. Please try again");
            return "user/add_agency";
        }

        boolean isValid = Utils.checkPasswordConfirmation(agent.getUPassword(), cPassword);
        if(!isValid){
            model.addAttribute("invalidConfirmation", "Password's confirmation is invalid. Please try again");
            return "user/add_agency";
        }

        //setRole
        String roles = Role.ROLE_AGENT_ADMIN.getRole()+","+Role.ROLE_AGENT_USER.getRole();
        agent.setURoles(roles);
        userService.saveUser(agent);
        agency.setAgents(List.of(agent));
        companyService.saveCompany(agency);
        return "redirect:/";
    }

    @RequestMapping(value = "user/{id}", method = RequestMethod.GET)
    public String getPropertyById(@PathVariable("id") Long id, Model model){
        Optional<User> user = userService.getUserById(id);
        if(user.isEmpty()){
            System.out.println("user not found");
        }
        if(user.get().getURoles().contains(Role.ROLE_PRIVATE_USER.getRole())){
            PrivateUser privateUser = (PrivateUser) user.get();
            model.addAttribute("privateUser", privateUser);
            model.addAttribute("username", privateUser.getUsername());
            return "user/user_view";
        }

        Agent agent = (Agent) user.get();
        model.addAttribute("agent", agent);
        return "user/agent_view";
    }



}
