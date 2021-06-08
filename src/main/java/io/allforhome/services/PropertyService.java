package io.allforhome.services;

import io.allforhome.exceptions.ResourceNotFoundException;
import io.allforhome.models.Property;
import io.allforhome.models.PropertyManager;
import io.allforhome.repositories.PropertyRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;

/**
 * @author mkemiche
 * @created 02/05/2021
 */
@Log
@Service
public class PropertyService {

    @Autowired
    ImageUploadService imageUploadService;

    @Autowired
    PropertyManager propertyManager;

    @Autowired
    private PropertyRepository propertyRepository;

    public List<Property> getAllProperties(){
        return propertyRepository.findAll();
    }


    public void createProperty(Object p){
        if(p == null){
            log.severe("Try to add property null");
            throw new ResourceNotFoundException();
        }

        LinkedHashMap<Object, Object> map = (LinkedHashMap) p;

    }

    public void updateProperty(Property property){
        if(property == null){
            log.severe("Try to update property null");
        }
        //FIXME add function update
        propertyRepository.save(property);
    }

    public Property findPropertyById(Long id){
        if(id == null){
            log.severe("id cannot be null");
            return null;
        }
        Optional<Property> p = propertyRepository.findById(id);

        if(p.isEmpty()){
            log.info("Property with id "+ id +" does not exist");
            return null;
        }
        return p.get();
    }

    public void removeProperty(Long id){
        Property property = findPropertyById(id);
        if(property == null){
            log.severe("Try to remove property null");
        }
        propertyRepository.delete(property);
    }

}
