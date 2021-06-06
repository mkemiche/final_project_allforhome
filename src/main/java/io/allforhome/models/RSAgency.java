package io.allforhome.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
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

    @Column(name = "company_number")
    private String companyNumber;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "company_phone")
    private String companyPhone;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id")
    private Location companyLocation;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @ToString.Exclude
    List<Agent> agents;

    public RSAgency(String companyNumber, String companyName, String companyPhone, Location companyLocation, List<Agent> agents) {
        this.companyNumber = companyNumber;
        this.companyName = companyName;
        this.companyPhone = companyPhone;
        this.companyLocation = companyLocation;
        this.agents = agents;
    }
}
