//package com.agenda.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//
//import static org.springframework.security.config.Customizer.withDefaults;
//
////@Configuration
////@EnableWebSecurity
////@EnableWebMvc
//public class WebSecurityConfiguration {
//
////    @Bean
////    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
////        http
////                .authorizeHttpRequests((authz) -> authz
////                        .anyRequest().authenticated()
////                ).oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
////
////        return http.build();
////    }
//}
