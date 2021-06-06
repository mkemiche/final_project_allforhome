package io.allforhome.repositories;

import io.allforhome.models.RSAgency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author mkemiche
 * @created 05/06/2021
 */

@Repository
public interface CompanyRepository extends JpaRepository<RSAgency, Long> {
}
