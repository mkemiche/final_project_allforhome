package io.allforhome.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author mkemiche
 * @created 05/06/2021
 */

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "rs_agency")
public class RSAgency implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(11) UNSIGNED")
    private Long id;

    @Column(name = "company_number")
    @NonNull
    private String companyNumber;

    @Column(name = "company_name")
    @NonNull
    private String companyName;

    @Column(name = "company_phone")
    @NonNull
    private String companyPhone;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id")
    @NonNull
    private Location companyLocation;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    @NonNull
    List<Agent> agents;
}
