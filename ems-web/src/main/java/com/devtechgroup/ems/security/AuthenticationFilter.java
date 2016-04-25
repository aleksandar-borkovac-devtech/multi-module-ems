package com.devtechgroup.ems.security;

import com.devtechgroup.ems.business.logic.model.CustomerDto;
import com.devtechgroup.ems.data.access.entity.Customer;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by aleksandar.borkovac on 4/21/2016.
 */
public class AuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        SecurityContextHolder.clearContext();

        CustomerDto customer = new CustomerDto(){{
            setId(1L);
            setUsername("borkke");
            setPassword("password");
            setFirstName("Aleksandar");
            setLastName("Borkovac");
            setEmail("borkke@gmail.com");
        }};
        SecurityContextHolder.getContext().setAuthentication(new EmsAuthentication(customer));

        chain.doFilter(request, response);
    }

}
