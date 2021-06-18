package io.allforhome.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author mkemiche
 * @created 30/04/2021
 */

@Data
@NoArgsConstructor

@Entity
@Table(name = "image")
public class Image {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "int(11) UNSIGNED")
    private Long id;

    @NotNull
    @NotEmpty(message = "This field is required")
    private String imageName;

    public Image(String imageName ) {
        this.imageName = imageName;
    }
}
