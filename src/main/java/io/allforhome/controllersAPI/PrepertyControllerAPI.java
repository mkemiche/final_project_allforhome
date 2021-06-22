package io.allforhome.controllersAPI;

import io.allforhome.models.Property;
import io.allforhome.services.PropertyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author mkemiche
 * @created 05/06/2021
 */

@RestController
@Api(value="API describe CRUD operation for property object")
@RequestMapping("api/property")
public class PrepertyControllerAPI {

    @Autowired
    PropertyService propertyService;

    @ApiOperation(value = "Return all properties existing in the database")
    @GetMapping(value = "/getallproperties", produces = "application/json")
    public List<Property> getAllProperties(){
        return propertyService.getAllProperties();
    }

    @ApiOperation(value = "Return property by its id if exists")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Property getProperyById(@PathVariable("id") Long id){
        //return RestPreconditions.checkFound
        Property p = propertyService.findPropertyById(id);
        return p;
    }

    @ApiOperation(value = "Register new property")
    @PostMapping(value = "/newproperty", produces = MediaType.APPLICATION_JSON_VALUE)
    public String newProperty(@RequestBody Property property){
        propertyService.createProperty(property);
        return "property added with reference"+property.getPReference();
    }

    @ApiOperation(value = "Update property by its id if exists")
    @PutMapping("/{id}")
    public String updateProperty(@PathVariable("id") Long id, @RequestBody Property newProperty){

        Property oldprop = propertyService.findPropertyById(id);
        propertyService.updateProperty(propertyService.setPropertyFields(oldprop, newProperty));
        return "property " +id+ " updated";
    }

    @ApiOperation(value = "Remove property by its id if exists")
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteProperty(@PathVariable("id") Long id){
        propertyService.removeProperty(id);
        return "property " +id+ " removed";
    }





}
