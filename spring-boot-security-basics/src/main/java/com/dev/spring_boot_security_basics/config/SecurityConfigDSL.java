package com.dev.spring_boot_security_basics.config;

import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
//@EnableWebSecurity
public class SecurityConfigDSL {

//    @Bean
//    @Order(1)
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests()
//                .requestMatchers("/").permitAll()
//                .requestMatchers("/api/posts/**").hasRole("ADMIN")
//                .anyRequest().authenticated()
//                .and()
//                .csrf().disable()
//                .httpBasic();
//        return http.build();
//    }

    /*
     Lambda DSL
     In the Lambda DSL there is no need to chain configuration options using the .and() method.
     The HttpSecurity instance is automatically returned for further configuration after the call to the lambda method.
     https://spring.io/blog/2019/11/21/spring-security-lambda-dsl
    */
//    @Bean
//    @Order(2)
    public SecurityFilterChain securityFilterChain2(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/").permitAll();
                    auth.requestMatchers("/api/posts/**").hasRole("ADMIN");
                    auth.anyRequest().authenticated();
                })
//                .csrf(csrf -> csrf.disable())
                .csrf(AbstractHttpConfigurer::disable)
                .httpBasic(Customizer.withDefaults())
                .build();
    }
}

