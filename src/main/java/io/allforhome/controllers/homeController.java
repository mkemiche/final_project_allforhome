package io.allforhome.controllers;

import io.allforhome.enums.Status;
import io.allforhome.models.Property;
import io.allforhome.services.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author mkemiche
 * @created 08/06/2021
 */

@Controller
@SessionAttributes("user")
public class homeController {

    private PropertyService propertyService;

    @Autowired
    public homeController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @ModelAttribute("email")
    public String initEmail(){
        return "";
    }

    @GetMapping("/")
    public String home(Model model){
        String path = File.separator+"fileupload" + File.separator;
        List<Property> propertiesForSale = propertyService.getAllProperties().stream().filter(e->e.getPStatus().equals(Status.SALE.name())).collect(Collectors.toList());
        List<Property> propertiesForRent = propertyService.getAllProperties().stream().filter(e->e.getPStatus().equals(Status.RENT.name())).collect(Collectors.toList());
        propertiesForSale.sort((o1, o2) -> o2.getId().compareTo(o1.getId()));
        propertiesForRent.sort((o1, o2) -> o2.getId().compareTo(o1.getId()));

        model.addAttribute("propertiesSale", propertiesForSale);
        model.addAttribute("propertiesRent", propertiesForRent);
        model.addAttribute("path", path);
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginUser(){
        return "user/login";
    }

    @RequestMapping(value = "/login/authenticate", method = RequestMethod.POST)
    public String authUser(@RequestParam("email") String email){
        System.out.println(email);
        return "redirect:/";
    }

    @RequestMapping(value = "/reset", method = RequestMethod.GET)
    public String resetPassword(){
        return "user/reset_password";
    }

    @RequestMapping(value = "/reset", method = RequestMethod.POST)
    public String resetPassword(@RequestParam("email") @Valid String email){
        System.out.println("email  " + email);
        return "user/reset_password";
    }
}
