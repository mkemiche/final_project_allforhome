package io.allforhome.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author mkemiche
 * @created 05/06/2021
 */

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@SuperBuilder
@DiscriminatorColumn(name="user_type")
public class User implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(11) UNSIGNED")
    private Long id;

    @NonNull
    private String email;

    @NonNull
    private String password;

    @NonNull
    private String roles;
}
