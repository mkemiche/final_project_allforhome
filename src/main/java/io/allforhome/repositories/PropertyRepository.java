package io.allforhome.repositories;

import io.allforhome.exceptions.PropertyNotFoundException;
import io.allforhome.models.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * @author mkemiche
 * @created 01/05/2021
 */

@Repository
@Transactional
public interface PropertyRepository extends JpaRepository<Property, Long> {

    Optional<Property> findPropertyBypReference(String ref) throws PropertyNotFoundException;
}
