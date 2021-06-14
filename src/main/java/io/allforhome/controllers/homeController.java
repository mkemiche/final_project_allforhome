package io.allforhome.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author mkemiche
 * @created 08/06/2021
 */

@Controller
public class homeController {

    @GetMapping("/")
    public String home(){
        return "index";
    }


}
