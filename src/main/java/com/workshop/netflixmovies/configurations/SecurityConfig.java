package com.workshop.netflixmovies.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;



import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig{

    @Autowired
    private final PasswordEncoder passwordEncoder;

    public SecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.DELETE).hasRole("admin")
                .antMatchers(HttpMethod.PUT).hasAnyRole("user", "admin")
                .antMatchers(HttpMethod.POST).hasAnyRole("user", "admin")
                .antMatchers(HttpMethod.GET).permitAll()
                .antMatchers("/actuator/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic();

        return http.build();
    }

    @Bean
    protected UserDetailsService userDetailsService() {

        UserDetails user = User.builder()
                .username("USER")
                .password(passwordEncoder.encode("password"))
                .roles("user")
                .build();

        UserDetails admin = User.builder()
                .username("ADMIN")
                .password(passwordEncoder.encode("password"))
                .roles("admin")
                .build();

        InMemoryUserDetailsManager userDeatils = new InMemoryUserDetailsManager(user, admin);
        return userDeatils;
    }

}