package com.example.SpringSecurityTalusko.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

//        httpSecurity.csrf();
//        httpSecurity.csrf(csrf -> csrf
//                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()) // Optional: You can configure the CSRF token repository
//        );

        return httpSecurity.csrf(customizer-> customizer.ignoringRequestMatchers("/**"))
                    .authorizeHttpRequests(request-> request.anyRequest().authenticated())
//                  .formLogin(Customizer.withDefaults());
                    .httpBasic(Customizer.withDefaults())
                    .sessionManagement(session->
                            session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)).build();
    }
    UserDetailsService userDetailsService()
    {
        return new InMemoryUserDetailsManager();
    }
}
