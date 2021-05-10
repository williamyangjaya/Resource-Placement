/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.finalproject.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author William Yangjaya
 */
public class MyUserDetails implements UserDetails {

    private Users users;

    public MyUserDetails() {

    }

    public MyUserDetails(Users users) {
        this.users = users;
    }

    public Integer getId() {
        return this.users.getUserId();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<Roles> roles = users.getRolesList();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        for (Roles r : roles) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + r.getRoleName().toUpperCase()));
            Collection<Privileges> privileges = r.getPrivilegesList();
            for (Privileges p : privileges) {
                authorities.add(new SimpleGrantedAuthority(p.getPrivilegeName().toUpperCase()));
            }
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.users.getPassword();
    }

    @Override
    public String getUsername() {
        return this.users.getUsername();
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
