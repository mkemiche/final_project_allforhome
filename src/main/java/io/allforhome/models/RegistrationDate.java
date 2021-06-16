package io.allforhome.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author mkemiche
 * @created 01/05/2021
 */

@Data
@NoArgsConstructor
@Entity
@Table(name = "registration")
public class RegistrationDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(11) UNSIGNED")
    private Long id;

    private LocalDateTime updateDate;

    public RegistrationDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }
}
