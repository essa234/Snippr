package com.example.Snippr.security;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SnipprSecurityConfig {

  @Bean
  public void configure(HttpSecurity httpSecurity) throws Exception {
    httpSecurity.csrf(AbstractHttpConfigurer::disable)
        .authorizeRequests().anyRequest().authenticated()
        .and().httpBasic(withDefaults());

  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests((authz) -> authz
            .anyRequest().authenticated()
        )
        .httpBasic(withDefaults());
    return http.build();
  }

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder authentication)
      throws Exception
  {
    authentication.inMemoryAuthentication()
        .withUser("admin")
        .password(passwordEncoder().encode("nimda"))
        .authorities("ROLE_USER");
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}