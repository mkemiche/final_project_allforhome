package io.allforhome.controllers;

import io.allforhome.enums.Status;
import io.allforhome.models.Property;
import io.allforhome.services.PropertyService;
import io.allforhome.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.File;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author mkemiche
 * @created 06/06/2021
 */

@Controller
@SessionAttributes("refProperty")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @ModelAttribute("property")
    public Property initProperty(){
        return new Property();
    }

    @ModelAttribute("refProperty")
    public String initRef(){
        return "";
    }

    @RequestMapping(value = "property/getallproperties", method = RequestMethod.GET)
    public String getAllProperties(Model model){
        List<Property> properties = propertyService.getAllProperties();
        model.addAttribute("properties", properties);
        return null;
    }

    @RequestMapping(value = "property/newproperty", method = RequestMethod.GET)
    public String newPropertyForm(Model model){
        String ref = Utils.generatePropertyRef();
        model.addAttribute("refProperty", ref);
        return "property/register_property";
    }

    @RequestMapping(value = "property/newproperty", method = RequestMethod.POST)
    public String saveProperty(@ModelAttribute("property") @Valid Property property,
                               BindingResult result,
                               Model model){

        if(result.hasErrors()){
            return "property/register_property";
        }
        String ref = (String) model.getAttribute("refProperty");
        property.setPReference(ref);
        propertyService.createProperty(property);
        return "redirect:/";
    }

    @RequestMapping(value = "property/{id}/updateproperty", method = RequestMethod.PUT)
    public String updateProperty(@PathVariable("id") Long id, @ModelAttribute("property") Property property){
        propertyService.updateProperty(property);

        return null;
    }

    @RequestMapping(value = "property/{id}/deleteproperty", method = RequestMethod.DELETE)
    public String deleteProperty(@PathVariable("id") Long id){
        propertyService.removeProperty(id);

        return null;
    }


    @RequestMapping(value = "/getlastaddedproperty", method = RequestMethod.GET)
    public String getLastAddedProperty(Model model, RedirectAttributes redirectAttributes){
        List<Property> properties = propertyService.getAllProperties().stream().sorted(Comparator.comparing(Property::getId).reversed()).collect(Collectors.toList());
        String path = File.separator+"fileupload" + File.separator;
        model.addAttribute("properties", properties);
        model.addAttribute("path", path);

        return "property/property_list";
    }

    @RequestMapping(value = "property/lastaddedsale", method = RequestMethod.GET)
    public String getLastAddedSale(Model model, RedirectAttributes redirectAttributes){
        List<Property> properties = propertyService.getAllProperties().stream().filter(e->e.getPStatus().equals(Status.SALE.name())).collect(Collectors.toList());
        properties.sort((o1, o2) -> o2.getId().compareTo(o1.getId()));
        String path = File.separator+"fileupload" + File.separator;
        model.addAttribute("properties", properties);
        model.addAttribute("path", path);

        return "property/property_listing";
    }

    @RequestMapping(value = "property/lastaddedrent", method = RequestMethod.GET)
    public String getLastAddedRent(Model model, RedirectAttributes redirectAttributes){
        List<Property> properties = propertyService.getAllProperties().stream().filter(e->e.getPStatus().equals(Status.RENT.name())).collect(Collectors.toList());
        properties.sort((o1, o2) -> o2.getId().compareTo(o1.getId()));
        String path = File.separator+"fileupload" + File.separator;
        model.addAttribute("properties", properties);
        model.addAttribute("path", path);

        return "property/property_listing";
    }


    @RequestMapping(value = "property/{id}", method = RequestMethod.GET)
    public String getPropertyById(@PathVariable("id") Long id, Model model){
        Property propery = propertyService.findPropertyById(id);
        model.addAttribute("property", propery);
        return "property/property_details";
    }

}