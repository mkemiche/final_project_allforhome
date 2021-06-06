package io.allforhome.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author mkemiche
 * @created 05/06/2021
 */

@Data
@NoArgsConstructor
@Entity
@DiscriminatorValue("private_user")
@SuperBuilder
public class PrivateUser extends User {

    private String username;

    public PrivateUser(String email, String password, String roles, String username) {
        super(email, password, roles);
        this.username = username;
    }
}
