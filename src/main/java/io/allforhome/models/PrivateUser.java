package io.allforhome.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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

    @NotNull
    @NotBlank(message = "This field is required")
    @Size(min = 3, max = 30, message = "This field must be between 3 and 30 characters")
    private String username;

    private Long id;

    public PrivateUser(String email, String password, String roles, String username) {
        super(email, password, roles);
        this.username = username;
        this.id = super.getUId();
    }
}
