package io.allforhome.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author mkemiche
 * @created 05/06/2021
 */

@Data
@NoArgsConstructor
@Entity
@SuperBuilder
@DiscriminatorValue("agent")
public class Agent extends User{

    private String title;
    private String agentFirstName;
    private String agentLastName;


    public Agent(String email, String password, String roles, String title, String agentFirstName, String agentLastName) {
        super(email, password, roles);
        this.title = title;
        this.agentFirstName = agentFirstName;
        this.agentLastName = agentLastName;
    }
}
