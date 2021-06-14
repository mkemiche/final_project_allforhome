package io.allforhome.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

/**
 * @author mkemiche
 * @created 05/06/2021
 */

@Data
@NoArgsConstructor
@Entity
@Table(name = "user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@SuperBuilder
@DiscriminatorColumn(name="user_type")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(11) UNSIGNED")
    private Long uId;

    private String uEmail;
    private String uPassword;
    private String uRoles;

    public User(String uEmail, String uPassword, String uRoles) {
        this.uEmail = uEmail;
        this.uPassword = uPassword;
        this.uRoles = uRoles;
    }
}
