package io.allforhome.controllers;

import io.allforhome.services.ImageUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.FileNotFoundException;

/**
 * @author mkemiche
 * @created 10/06/2021
 */

@Controller
public class UploadController {

    @Autowired
    private ImageUploadService imageUploadService;

    @ModelAttribute("pReference")
    public String initRef(){
        return "";
    }

    @GetMapping("/uploadForm")
    public String uploadFile(){
        return "img-upload";
    }


    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public String uploadFile(@ModelAttribute("file") MultipartFile file,
                             @RequestParam("ref") String ref,
                             RedirectAttributes redirectAttributes) throws FileNotFoundException {

        if(file.isEmpty()){
            throw new FileNotFoundException("Atteched file not found");
        }
        imageUploadService.saveImage(file, ref);
        return "redirect:/uploadForm";
    }

}
