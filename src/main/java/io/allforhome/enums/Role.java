package io.allforhome.enums;

/**
 * @author mkemiche
 * @created 05/06/2021
 */
public enum Role {

    ROLE_SUPER_ADMIN("SUPER_ADMIN"),
    ROLE_AGENT_ADMIN("AGENT_ADMIN"),
    ROLE_AGENT_USER("AGENT_USER"),
    ROLE_PRIVATE_USER("USER");

    private String role;

    Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
