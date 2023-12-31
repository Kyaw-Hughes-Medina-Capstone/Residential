package com.codeup.rentlister.security;

import com.codeup.rentlister.services.UserDetailsLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    private UserDetailsLoader UsersLoader;

    public SecurityConfiguration(UserDetailsLoader UsersLoader) {
        this.UsersLoader = UsersLoader;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests) -> requests
                        /* Pages that require authentication
                         * only authenticated users can create and edit ads */
                        .requestMatchers("/property/create", "/property/*/edit", "/property/workorder", "/property/*/inquiry", "/property/*/review", "/owner/portfolio").authenticated()
                        /* Pages that do not require authentication


                         * anyone can visit the home page, register, login, and view ads */

//                        .requestMatchers("/", "/property", "/property/*","/about", "/sign-up", "/login", "/owner/portfolio", "/property/*/detail").permitAll()

                   


//                          anyone can visit the home page, register, login, and view
//                        .requestMatchers("/", "/property", "/property/*", "/sign-up", "/login", "/about", "/home", "/landing.mp4", "/chip.png", "/property/*/detail").permitAll()


//                          anyone can visit the home page, register, login, and view
                        .requestMatchers("/", "/property", "/property/*", "/sign-up", "/login", "/about", "/home", "/tenant/*", "/contact","/filtered-properties", "/property/*/detail" ).permitAll()

                        // allow loading of static resources
                                .requestMatchers("/css/**", "/js/**", "/img/**", "/pdf/**", "/landing.mp4", "/residentialLease.pdf").permitAll()
                )
                /* Login configuration */
                .formLogin((login) -> login.loginPage("/login").defaultSuccessUrl("/home"))
                /* Logout configuration */
                .logout((logout) -> logout.logoutSuccessUrl("/home"))
                .httpBasic(withDefaults());
        return http.build();
    }
}