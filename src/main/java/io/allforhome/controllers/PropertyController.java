package io.allforhome.controllers;

import io.allforhome.models.Property;
import io.allforhome.services.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author mkemiche
 * @created 06/06/2021
 */

@Controller
@RequestMapping("/property")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;


    @GetMapping("/getallproperties")
    public String getAllProperties(Model model){
        List<Property> properties = propertyService.getAllProperties();
        model.addAttribute("properties", properties);
        return null;
    }

    @GetMapping("/newproperty")
    public String saveProperty(@RequestParam("file") MultipartFile file,
                               @ModelAttribute("property") Property property,
                               Model model){

        propertyService.createProperty(property);
        return null;
    }

    @PutMapping("/{id}/updateproperty")
    public String updateProperty(@PathVariable("id") Long id, @ModelAttribute("property") Property property){
        propertyService.updateProperty(property);

        return null;
    }

    @DeleteMapping("/{id}/deleteproperty")
    public String deleteProperty(@PathVariable("id") Long id){
        propertyService.removeProperty(id);

        return null;
    }


}
