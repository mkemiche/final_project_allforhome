package io.allforhome.repositories;

import io.allforhome.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author mkemiche
 * @created 05/06/2021
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
