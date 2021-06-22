package io.allforhome.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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

    @NotNull
    @NotBlank(message = "This field is required")
    private String uEmail;

    @NotNull
    @NotBlank(message = "This field is required")
    private String uPassword;

    private String uRoles;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "Registration_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private RegistrationDate registration = new RegistrationDate();

    public User(String uEmail, String uPassword, String uRoles) {
        this.uEmail = uEmail;
        this.uPassword = uPassword;
        this.uRoles = uRoles;
    }
}
