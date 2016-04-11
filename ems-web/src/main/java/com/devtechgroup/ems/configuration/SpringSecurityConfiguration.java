package com.devtechgroup.ems.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select username,password, enabled from users where username=?")
                .authoritiesByUsernameQuery("select username, role from user_roles where username=?");
    }


    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers().permitAll()
                .antMatchers("/api/customer").anonymous()
                .antMatchers("/api/**").hasAnyRole("ADMIN")
                .antMatchers("/api/customer/**").hasAnyRole("USER")
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/api").defaultSuccessUrl("/api/customer")
                .usernameParameter("username").passwordParameter("password")
                .and()
                .logout().logoutSuccessUrl("/api")
                .and()
                .exceptionHandling().accessDeniedPage("/403")
                .and()
                .csrf();

    }

   /* @Bean(name = "dataSource")
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/simple_application");
        driverManagerDataSource.setUsername("exampleUser");
        driverManagerDataSource.setPassword("P@ssword");
        return driverManagerDataSource;
    }*/

}
