package com.clinident.security.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class HttpSecurityConfig {

    private final AuthenticationProvider daoAuthProvider;

    @Bean
    public SecurityFilterChain httpSecurityFilterChain(HttpSecurity http) throws Exception {

        return http.csrf(csrfConfig-> csrfConfig.disable())
                .sessionManagement(sessMagConfig->sessMagConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(daoAuthProvider)
                .authorizeHttpRequests(authReqConfig->{
                    authReqConfig.requestMatchers(HttpMethod.POST,"/api/v1/auth/**").permitAll();
                    //authReqConfig.requestMatchers(HttpMethod.POST,"/api/v1/auth/").permitAll();
                }).build();
    }

}
