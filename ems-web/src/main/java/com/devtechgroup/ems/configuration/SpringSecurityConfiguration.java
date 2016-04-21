package com.devtechgroup.ems.configuration;

import com.devtechgroup.ems.security.AuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.GenericFilterBean;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select username,password, enabled from ems.customer where username=?")
                .authoritiesByUsernameQuery("select username, name from ems.customer  join ems.customer_authority on customer_id = id where username=?");
    }

    protected void configure(HttpSecurity http) throws Exception {

        http
                .csrf()
                .disable();

        http
                .addFilterAfter(apiAuthenticationFilter(), BasicAuthenticationFilter.class);

        http
                .authorizeRequests()
                .antMatchers("/").permitAll();

        /*http
                .csrf()
                    .disable();
        http
                    .formLogin()
                    .loginProcessingUrl("/api/authentication")
                    .usernameParameter("username")
                    .passwordParameter("password")
                    .permitAll()
                .and()
                    .logout()
                    .logoutUrl("/api/logout")
                    .deleteCookies("JSESSIONID", "CSRF-TOKEN")
                    .permitAll()
                .and()
                    .headers()
                    .frameOptions()
                    .disable()
                .and()
                    .authorizeRequests()
                    .antMatchers("/").permitAll();*/

    }

    @Bean
    public GenericFilterBean apiAuthenticationFilter() {
        return new AuthenticationFilter();
    }

}
