package io.allforhome.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author mkemiche
 * @created 30/04/2021
 */

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "image")
public class Image implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(11) UNSIGNED")
    private Long id;

    @NonNull
    private String imageName;
    //private String uploadDir;
}
