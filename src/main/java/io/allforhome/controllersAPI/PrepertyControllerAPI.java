package io.allforhome.controllersAPI;

import io.allforhome.models.Property;
import io.allforhome.services.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author mkemiche
 * @created 05/06/2021
 */

@RestController
@RequestMapping("api/property")
public class PrepertyControllerAPI {

    @Autowired
    PropertyService propertyService;

    @GetMapping(value = "/getallproperties", produces = "application/json")
    public List<Property> getAllProperties(){
        return propertyService.getAllProperties();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Property getProperyById(@PathVariable("id") Long id){
        //return RestPreconditions.checkFound
        Property p = propertyService.findPropertyById(id);
        return p;
    }

    @PostMapping("/newproperty")
    public void newProperty(@RequestBody Property property){
        propertyService.createProperty(property);
    }

    @PutMapping("/{id}/updateproperty")
    public void updateProperty(@PathVariable("id") Long id, @RequestBody Property property){
        propertyService.updateProperty(property);
    }

    @DeleteMapping("/{id}/deleteproperty")
    public void deleteProperty(@PathVariable("id") Long id){
        propertyService.removeProperty(id);
    }





}
