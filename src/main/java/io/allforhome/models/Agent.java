package io.allforhome.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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

    @NotNull
    @NotEmpty(message = "This field is required")
    private String title;

    @NotNull
    @NotEmpty(message = "This field is required")
    @Size(min = 3, max = 30, message = "This field must be between 3 and 30 characters")
    private String agentFirstName;

    @NotNull
    @NotEmpty(message = "This field is required")
    @Size(min = 3, max = 30, message = "This field must be between 3 and 30 characters")
    private String agentLastName;

    private Long agents_id = 0L;

    public Agent(String email, String password, String roles, String title, String agentFirstName, String agentLastName) {
        super(email, password, roles);
        this.title = title;
        this.agentFirstName = agentFirstName;
        this.agentLastName = agentLastName;
    }
}
