package io.allforhome.services;

import io.allforhome.exceptions.PropertyNotFoundException;
import io.allforhome.exceptions.UserNotFoundException;
import io.allforhome.models.Image;
import io.allforhome.models.Property;
import io.allforhome.models.RegistrationDate;
import io.allforhome.repositories.PropertyRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
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
    private PropertyRepository propertyRepository;

    private static final SimpleDateFormat DATE_FORMATER = new SimpleDateFormat("mm/dd/yyy HH:mm");

    public List<Property> getAllProperties(){
        List<Property> properties = propertyRepository.findAll();
        return properties;
    }


    public void createProperty(Property property){
        if(property == null){
            log.severe("Try to add property null");
            throw new UserNotFoundException("Try to add property null");
        }

        property.setPUpdateDate(new RegistrationDate(LocalDateTime.now()));
        List<Image> images = imageUploadService.getAllImagesByRefProperty(property.getPReference());
        property.setPImages(images);
        propertyRepository.save(property);
    }

    public void updateProperty(Property property){
        if(property == null){
            log.severe("Try to update property null");
            throw new PropertyNotFoundException("Requested property not found");
        }
        propertyRepository.save(property);
    }

    public Property findPropertyById(Long id){
        Optional<Property> p = propertyRepository.findById(id);

        if(p.isEmpty()){
            log.info("Property with id "+ id +" does not exist");
            throw new PropertyNotFoundException("Property id: "+id+" not found");
        }
        return p.get();
    }

    public void removeProperty(Long id){
        /*Property property = findPropertyById(id);
        if(property == null){
            log.info("Property with id "+ id +" does not exist");
            throw new PropertyNotFoundException("Property id: "+id+" not found");
        }*/
        propertyRepository.deleteById(id);
    }

    public List<Property> findAllPropertiesByUser(Long id){
        return propertyRepository.findPropertiesByUser(id);
    }

    public Property setPropertyFields(Property oldprop, Property newProperty) {
        oldprop.setPArea(newProperty.getPArea());
        oldprop.setPDescription(newProperty.getPDescription());
        oldprop.setPBathrooms(newProperty.getPBathrooms());
        oldprop.setPTitle(newProperty.getPTitle());
        oldprop.setPBedrooms(newProperty.getPBedrooms());
        oldprop.setPPrice(newProperty.getPPrice());
        oldprop.setPType(newProperty.getPType());

        return oldprop;
    }
}
