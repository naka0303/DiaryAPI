package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


/**
 * WebSecurityConfigクラス.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
  
  /**
   * securityFilterChainクラス.
   */
  @Bean
  protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

    http.csrf()
            .disable()
            .authorizeHttpRequests(authz -> authz
                    .requestMatchers(HttpMethod.POST, "/v1/login").permitAll()
                    .requestMatchers(HttpMethod.POST, "/v1/logout").permitAll()
                    .requestMatchers(HttpMethod.GET, "/v1/users/**").permitAll()
                    .requestMatchers("/v1/users").permitAll()
                    .anyRequest().authenticated());

    return http.build();
  }
  
  public CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration corsConfiguration = new CorsConfiguration();
    corsConfiguration.addAllowedOrigin("http://localhost:8081");
    corsConfiguration.addAllowedOrigin("http://localhost:4000");
    corsConfiguration.addAllowedMethod(CorsConfiguration.ALL);
    corsConfiguration.addAllowedHeader(CorsConfiguration.ALL);
    corsConfiguration.setAllowCredentials(true);

    UrlBasedCorsConfigurationSource corsSource = new UrlBasedCorsConfigurationSource();
    corsSource.registerCorsConfiguration("/v1/csrf", corsConfiguration);

    return corsSource;
  }
  
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
  
  @Bean
  public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
    return http.getSharedObject(AuthenticationManagerBuilder.class)
    .build();
  }
}
