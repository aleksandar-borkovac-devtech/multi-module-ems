package com.devtechgroup.ems.security;

import com.devtechgroup.ems.business.logic.model.CustomerDto;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;

public class EmsAuthentication implements Authentication {

    private CustomerDto _customer;

    public EmsAuthentication() {
        super();
    }

    public EmsAuthentication(CustomerDto customer) {
        super();
        _customer = customer;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> grantedRoleList = new ArrayList<>();
        grantedRoleList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        grantedRoleList.add(new SimpleGrantedAuthority("ROLE_USER"));
        return grantedRoleList;
    }

    @Override
    public Object getCredentials() {
        return "123456";
    }

    @Override
    public Object getDetails() {
        return _customer;
    }

    @Override
    public Object getPrincipal() {
        return _customer;
    }

    @Override
    public boolean isAuthenticated() {
        return true;
    }

    @Override
    public void setAuthenticated(boolean b) throws IllegalArgumentException {

    }

    @Override
    public String getName() {
        return null;
    }
}
