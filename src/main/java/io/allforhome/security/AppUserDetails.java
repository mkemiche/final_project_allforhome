package io.allforhome.security;


import io.allforhome.models.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author mkemiche
 * @created 21/06/2021
 */
public class AppUserDetails implements UserDetails {


    User user;
    List<String> roleList;

    public AppUserDetails(User user, List<String> roleList) {
        this.user = user;
        this.roleList = roleList;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> grList = new ArrayList<>();
        roleList.forEach(role -> grList.add(new SimpleGrantedAuthority(role)));
        return grList;
    }

    @Override
    public String getPassword() {
        return user.getUPassword();
    }

    @Override
    public String getUsername() {
        return user.getUEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
