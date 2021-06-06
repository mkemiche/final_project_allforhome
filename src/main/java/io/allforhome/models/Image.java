package io.allforhome.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(11) UNSIGNED")
    private Long id;
    private String imageName;
    //private String uploadDir;

    public Image(String imageName ) {
        this.imageName = imageName;
      //  this.uploadDir = uploadDir;
    }
}
