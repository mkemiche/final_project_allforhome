package io.allforhome.repositories;

import io.allforhome.exceptions.PropertyNotFoundException;
import io.allforhome.models.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * @author mkemiche
 * @created 01/05/2021
 */

@Repository
@Transactional
public interface PropertyRepository extends JpaRepository<Property, Long> {

    Optional<Property> findPropertyBypReference(String ref) throws PropertyNotFoundException;

    @Query(value = "select * from property p where p.user_id = :id", nativeQuery = true)
    List<Property> findPropertiesByUser(@Param("id") Long id);
}
