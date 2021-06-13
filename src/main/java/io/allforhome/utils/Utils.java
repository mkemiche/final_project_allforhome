package io.allforhome.utils;

import io.allforhome.repositories.ImageUploadRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author mkemiche
 * @created 06/06/2021
 */
public class Utils {

    private static Random rend = new Random();
    @Autowired
    private ImageUploadRepository imageUploadRepository;

    private static AtomicInteger counter = new AtomicInteger(0);

    public static String generateImageName(String pRef, String fileExtension){
        return String.format("PJ_%s_%d%s", pRef, counter.getAndIncrement(), fileExtension);
    }

    public static String generatePropertyRef(){
        return String.format("REF%s", rend.nextInt(100000000));
    }
}
