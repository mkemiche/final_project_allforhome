package io.allforhome.models;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor
@Entity
@DiscriminatorValue("private_user")
@SuperBuilder
public class PrivateUser extends User {


    private String username;
}
