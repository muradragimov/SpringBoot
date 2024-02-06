package com.example.mapper.config;

import com.example.mapper.dao.entity.StudentEntity;
import com.example.mapper.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;/*
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.*;*/
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;/*
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;*/

import java.util.Optional;

@Configuration
public class SecurityConfig {

    private final StudentService studentService;

    @Autowired
    public SecurityConfig(StudentService studentService) {
        this.studentService = studentService;
    }

  /*  @Bean
    public UserDetailsService userDetailsService(){

        return (UserDetailsService) (name) ->{
            Optional<StudentEntity> user = studentService.getStudentByName(name);
            if(user.isEmpty()){
                throw new UsernameNotFoundException("Not Found: " + name);
            }

            return (UserDetails) User.withUsername(user.get().getName())
                    .password(user.get().getPassword())
                    .roles("USER")
                    .build();
        };
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
*//*
        http.csrf(csrf -> csrf.disable());
        http.sessionManagement(httpSecuritySessionManagementConfigurer ->
                httpSecuritySessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS));*//*

      *//*   http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/edit/**").permitAll()
                        .anyRequest().authenticated());*//*

        return http.build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
    }*/

    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return new BCryptPasswordEncoder();
    }
}
