//package com.mbti.user.config.auth;
//
//import lombok.AllArgsConstructor;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
//
//@EnableResourceServer
//@Configuration
//public class ResourceServerConfig extends ResourceServerConfigurerAdapter
//{
//    @Override
//    public void configure(HttpSecurity http) throws Exception
//    {
//        http.authorizeRequests()
//                .antMatchers(HttpMethod.OPTIONS).permitAll()
//                .antMatchers("/api/**").hasAnyRole("USER", "ADMIN")
//                .anyRequest().authenticated();
//    }
//}
