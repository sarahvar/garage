package com.example.garageApp.security;

import java.util.Arrays;
import java.util.Collections;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;

import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {
	
	@Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("Content-Type", "Authorization"));
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}

    @SuppressWarnings("deprecation")
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .cors().configurationSource(corsConfigurationSource())
            .and()
            .csrf().disable()
            .authorizeRequests((authorize) -> {
                authorize.requestMatchers("/login").permitAll();
                authorize.requestMatchers("/cars/**","/cars/createCar").authenticated();
                authorize.anyRequest().authenticated();
                })
            .httpBasic(Customizer.withDefaults());
        return http.build();
    }
    
    @Bean
    public UserDetailsService userDetailsService() {
		UserDetails user = User.builder()
				.username("username")
				.password(passwordEncoder().encode("password"))
				.roles("USER")
				.build();
		
		UserDetails admin = User.builder()
				.username("username")
				.password(passwordEncoder().encode("password"))
				.roles("ADMIN")
				.build();
		return new InMemoryUserDetailsManager(user, admin);
	}
}

	
