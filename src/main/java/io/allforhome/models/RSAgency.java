package io.allforhome.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author mkemiche
 * @created 05/06/2021
 */

@Data
@NoArgsConstructor

@Entity
@Table(name = "rs_agency")
public class RSAgency {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(11) UNSIGNED")
    private Long id;

    @NotNull
    @NotBlank(message = "This field is required")
    private String companyNumber;

    @NotNull
    @NotBlank(message = "This field is required")
    private String companyName;

    private String companyPhone;

    private String companyEmail;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id")
    @Valid
    private Location companyLocation;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    List<Agent> agents;

    public RSAgency(String companyNumber, String companyName, String companyPhone, String companyEmail, Location companyLocation, List<Agent> agents) {
        this.companyNumber = companyNumber;
        this.companyName = companyName;
        this.companyPhone = companyPhone;
        this.companyEmail = companyEmail;
        this.companyLocation = companyLocation;
        this.agents = agents;
    }
}
