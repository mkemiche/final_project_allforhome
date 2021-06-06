package io.allforhome.repositories;

import io.allforhome.models.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author mkemiche
 * @created 01/05/2021
 */

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {
}
