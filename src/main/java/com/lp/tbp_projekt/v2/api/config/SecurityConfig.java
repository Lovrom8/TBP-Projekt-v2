package com.lp.tbp_projekt.v2.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
    private static final String[] AUTH_WHITELIST = {
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui/**",
            "/webjars/**"
    };

    private static final String[] ROUTES = {
            "/error",
            "/api/auth",
            "/api/auth/register",
            "/api/users",
            "/api/users/**",
            "/api/user",
            "/api/user/**",
            "api/user/liked/subgenres",
            "api/user/liked/genres",
            "/api/genres",
            "/api/genres/**",
            "/api/subgenres",
            "/api/subgenres/**",
            "/api/recommendation",
            "/api/songs/**"
    };

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception
    {
        httpSecurity
                .authorizeRequests().antMatchers(ROUTES).permitAll().antMatchers(AUTH_WHITELIST).permitAll()
                .anyRequest().authenticated().and().formLogin();
        httpSecurity.csrf().ignoringAntMatchers(ROUTES);
        //httpSecurity.csrf().disable();
        httpSecurity.headers().frameOptions().sameOrigin();
    }
}