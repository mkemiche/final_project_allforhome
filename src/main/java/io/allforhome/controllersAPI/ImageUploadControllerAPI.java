package io.allforhome.controllersAPI;

import io.allforhome.services.ImageUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author mkemiche
 * @created 05/06/2021
 */
@RestController
public class ImageUploadControllerAPI {

   // private static final String SUB_DIR = "/Users/mouloudkemiche/perscholas/final_project/final_project_allforhome/src/main/resources/upload";

    @Autowired
    private ImageUploadService imageUploadService;

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST, produces = "application/json")
    public String handleImageUpload(@RequestParam("file") MultipartFile file,
                                    @RequestParam("pRef") String preference){

        String filename = imageUploadService.saveImage(file, preference);

        return filename;
    }


}
