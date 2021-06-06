package io.allforhome.services;

import io.allforhome.models.Image;
import io.allforhome.repositories.ImageUploadRepository;
import io.allforhome.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

/**
 * @author mkemiche
 * @created 05/06/2021
 */

@Service
public class ImageUploadService {

    @Value("${app.upload.dir:${user.home}}")
    private String uploadDir;

    @Autowired
    ImageUploadRepository imageUploadRepository;




    public String saveImage(MultipartFile file, String pRef, Long userId){
        String originalName = StringUtils.cleanPath(file.getOriginalFilename());
        String fileName ="";
        String fileExtension = "";
        Image image;

        try {
            if(originalName.contains("..")){
                throw new Exception();
               // throw new DocumentStorageException("Sorry! Filename contains invalid path sequence " + originalFileName);
            }
            try {
                fileExtension = originalName.substring(originalName.lastIndexOf("."));
            }catch (Exception e){
                e.getStackTrace();
            }
            fileName = Utils.generateImageName(pRef, fileExtension);
            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = Paths.get(uploadDir).toAbsolutePath().normalize().resolve(fileName);
           // Path targetLocation = Paths.get(uploadDir+ File.separator+StringUtils.cleanPath(fileName));
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            image = new Image(fileName);
            imageUploadRepository.save(image);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileName;
    }

    public List<Image> getAllImagesByRefProperty(String ref){
        return imageUploadRepository.findAllByImageNameContaining(ref);
    }

}
