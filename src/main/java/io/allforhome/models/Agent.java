package io.allforhome.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author mkemiche
 * @created 05/06/2021
 */

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@SuperBuilder
@DiscriminatorValue("agent")
public class Agent extends User{

    @NonNull
    private String title;

    @NonNull
    private String agentFirstName;

    @NonNull
    private String agentLastName;
}
