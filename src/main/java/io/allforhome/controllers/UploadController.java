package io.allforhome.controllers;

import io.allforhome.services.ImageUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;

/**
 * @author mkemiche
 * @created 10/06/2021
 */

@Controller
public class UploadController {

    @Autowired
    private ImageUploadService imageUploadService;

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public String uploadFile(@ModelAttribute("file") MultipartFile file,
                             @RequestParam("pReference") String ref,
                             RedirectAttributes redirectAttributes){
        String filename = imageUploadService.saveImage(file, ref);

        redirectAttributes.addFlashAttribute("message", "You successfully uploaded " + filename);
        redirectAttributes.addFlashAttribute("filename", "fileupload"+ File.separator+filename);

        return "redirect:/property/newproperty";
    }

}
