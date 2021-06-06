package io.allforhome.repositories;

import io.allforhome.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author mkemiche
 * @created 05/06/2021
 */

@Repository
public interface ImageUploadRepository extends JpaRepository<Image, Long> {

    List<Image> findAllByImageNameContaining(String Ref);
    boolean existsByImageNameContaining(String Ref);
}
