package com.leadtech.lookbook.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	 @Bean
	    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
	        UserDetails admin = User.withUsername("adminFiap")
	            .password(passwordEncoder.encode("admin123"))
	            .roles("ADMIN")
	            .build();

	        UserDetails user = User.withUsername("user")
	            .password(passwordEncoder.encode("user123"))
	            .roles("USER")
	            .build();

	        return new InMemoryUserDetailsManager(admin, user);
	    }
	 
	 @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests((requests) -> requests
                .requestMatchers("/login", "/logout", "/**?lang=*").permitAll() 
                .requestMatchers("/monitor/**").hasRole("ADMIN") 
                .anyRequest().authenticated()
            )
            .formLogin((form) -> form
                .loginPage("/login")
                .defaultSuccessUrl("/clothing")
                .failureUrl("/login?falha=true")
                .permitAll())
            .logout((logout) -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout=true")
                .permitAll())
	        .exceptionHandling((exception) -> 
			exception.accessDeniedHandler(
					(request,response,AccessDeniedException) -> {response.sendRedirect("/acesso_negado");}));

        return http.build();
    }
}

