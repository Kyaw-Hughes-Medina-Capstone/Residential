package com.codeup.rentlister.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		http
				.headers(headers -> headers.frameOptions(frameOptions -> frameOptions.sameOrigin())) // Set X-Frame-Options header
				.authorizeHttpRequests(requests -> requests
						/* Pages that require authentication */
						.requestMatchers("").authenticated()
						/* Pages that do not require authentication */
						.requestMatchers("/home", "/", "/property", "/property/*", "/sign-up", "/login", "/property/create", "/property/*/edit", "/property/show", "property/*/inquiry", "property/workorder", "tenant/lease", "tenant/move-in", "tenant/index", "KXZ-logo.png", "residentialLease.pdf", "/filtered-properties", "/static/js/map.js", "/property/*/review").permitAll()
						// allow loading of static resources
						.requestMatchers("/css/**", "/js/**", "/img/**").permitAll()
				)
				/* Login configuration */
				.formLogin((login) -> login.loginPage("/login").defaultSuccessUrl("/property"))
				.logout((logout) -> logout.logoutSuccessUrl("/login"))
				.httpBasic(withDefaults());

		return http.build();
	}

}
