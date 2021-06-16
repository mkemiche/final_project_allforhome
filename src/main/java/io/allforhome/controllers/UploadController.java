package io.allforhome.controllers;

import io.allforhome.services.ImageUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String uploadFile(@ModelAttribute("files") MultipartFile[] files,
                             @RequestParam("pReference") String ref,
                             RedirectAttributes redirectAttributes) {

        imageUploadService.saveImage(files, ref);

       // List<String> filesUploaded = imageUploadService.getAllImagesByRefProperty(ref).stream().map(i-> "fileupload" + File.separator + i.getImageName()).collect(Collectors.toList());
        //redirectAttributes.addFlashAttribute("message", "You successfully uploaded " + filename);
       // redirectAttributes.addFlashAttribute("files", filesUploaded);

        return "redirect:/uploadForm";
    }

}
