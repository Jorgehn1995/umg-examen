package com.umg.examen.security;


import com.umg.examen.entities.Authority;
import org.springframework.security.core.GrantedAuthority;

public class SecurityAuthority implements GrantedAuthority {
    private final Authority authority;
    public SecurityAuthority(Authority authority){
        this.authority = authority;
    }
    @Override
    public String getAuthority() {
        return this.authority.getName().toString();
    }
}