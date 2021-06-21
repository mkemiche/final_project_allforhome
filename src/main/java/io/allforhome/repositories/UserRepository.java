package io.allforhome.repositories;

import io.allforhome.exceptions.UserNotFoundException;
import io.allforhome.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * @author mkemiche
 * @created 05/06/2021
 */

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByuEmail(String email) throws UserNotFoundException;
}
