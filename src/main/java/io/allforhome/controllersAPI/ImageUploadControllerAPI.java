package io.allforhome.controllersAPI;

import io.allforhome.services.ImageUploadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author mkemiche
 * @created 05/06/2021
 */
@RestController
@Api(value="API allows to upload an attached file")
public class ImageUploadControllerAPI {

   // private static final String SUB_DIR = "/Users/mouloudkemiche/perscholas/final_project/final_project_allforhome/src/main/resources/upload";

    @Autowired
    private ImageUploadService imageUploadService;

    @ApiOperation(value = "upload file and save it in the database")
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST, produces = "application/json")
    public String handleImageUpload(@RequestParam("file") MultipartFile file,
                                    @RequestParam("pRef") String preference){

        String filename = imageUploadService.saveImage(file, preference);

        return filename;
    }


}
