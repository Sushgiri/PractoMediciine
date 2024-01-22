package com.product.shopping.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.HttpMethod;


//package com.product.shopping.config;
//
//
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//
////
////@Configuration
////@EnableWebSecurity
////@EnableGlobalMethodSecurity(prePostEnabled = true)
////public class SecurityConfig extends WebSecurityConfigurerAdapter {
////    @Bean
////    public PasswordEncoder getencodedpassword(){
////        return new BCryptPasswordEncoder();
////    }
////
////    @Autowired
////    private PasswordEncoder passwordEncoder;
//
////    @Override
////    protected void configure(HttpSecurity http) throws Exception {
////        http
////                .csrf().disable()
////                .authorizeRequests()
////                .antMatchers(HttpMethod.GET,"/shopping/**").hasRole("USER")
////                .antMatchers(HttpMethod.DELETE,"/shopping/**").hasRole("ADMIN")
////                .antMatchers(HttpMethod.PUT,"/shopping/**").hasRole("ADMIN")
////                .antMatchers(HttpMethod.POST,"/shopping/**").hasRole("ADMIN")
////                .antMatchers(HttpMethod.GET,"/comment/**").hasRole("ANALYST")
////                .antMatchers(HttpMethod.DELETE,"/comment/**").hasRole("COMMENTOR")
////
////                .anyRequest()
////                .authenticated() // All other requests require authentication
////                .and();
////        http.httpBasic();
////
////    }
////
////    @Override
////    @Bean
////    protected UserDetailsService userDetailsService() {
////        UserDetails admin = User.builder().username("raghav").password(passwordEncoder.encode("Admin123")).roles("ADMIN").build();
////        UserDetails user = User.builder().username("shyam").password(passwordEncoder.encode("Mylog123")).roles("USER").build();
////        UserDetails analyst = User.builder().username("david").password(passwordEncoder.encode("comments123")).roles("ANALYST").build();
////        UserDetails commentor = User.builder().username("jack").password(passwordEncoder.encode("rider123")).roles("COMMENTOR").build();
////
////        return new InMemoryUserDetailsManager(user,admin,analyst,commentor);
////
////    }
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig  extends WebSecurityConfigurerAdapter {
//
//
//    //
//    @Bean
//    public PasswordEncoder getencodedpassword() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
////
////
////
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers(HttpMethod.GET,"/medicine/**").hasRole("ADMIN")
//                .antMatchers(HttpMethod.DELETE,"/medicine/**").hasRole("ADMIN")
//                .antMatchers(HttpMethod.PUT,"/medicine/**").hasRole("ADMIN")
//                .antMatchers(HttpMethod.POST,"/medicine/**").hasRole("ADMIN")
//
//
//                .antMatchers(HttpMethod.GET,"/order/**").hasRole("USER")
//                .antMatchers(HttpMethod.DELETE,"/order/**").hasRole("USER")
//                .antMatchers(HttpMethod.PUT,"/order/**").hasRole("USER")
//                .antMatchers(HttpMethod.POST,"/order/**").hasRole("USER")
//                .anyRequest()
//                .authenticated() // All other requests require authentication
//                .and();
//        http.httpBasic();
//
//     }
////
//@Bean
//public UserDetailsService userDetailsService() {
//    UserDetails user = User.builder()
//            .username("raghav")
//            .password(passwordEncoder.encode("user123"))
//            .roles("USER")
//            .build();
//    UserDetails admin = User.builder().username("rahul").password(passwordEncoder.encode("admin123")).roles("ADMIN").build();
////
//    return new InMemoryUserDetailsManager(user,admin);
//}
//}
////}
