package com.programing.discoveryservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Value("${app.eureka.username}")
    private String username;
    @Value("${app.eureka.password}")
    private String password;

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username(username)
                .password(password)
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests((authz) -> authz
                        .anyRequest().authenticated()
                )
                .httpBasic(withDefaults());
        return http.build();
    }

//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .passwordEncoder(NoOpPasswordEncoder.getInstance())
//                .withUser(username).password(password)
//                .authorities("USER");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//                .authorizeRequests().anyRequest()
//                .authenticated()
//                .and()
//                .httpBasic();
//    }
}

// In addition to my idea, I want to add a few more ideas.


/*
 - street vendor : the street vendor often go around my apartment
 - street vending: Street vending is common in my country
 - globe:
 - global: -> global warming
 - firm: ->
 - tourist: --> The tourist to brings advantages more than disadvantages
 - tourism: --> tourism industry
 - relax: --> he is feeling stress. i think he needs to get away for few day to relax.
 - stress
 - open-minded: -> i think of myself as an open-minded person.
 - narrow-minded: -> i consider myself to be an open-minded person, not  a narrow-minded one.
 - expand: --> to expand programme/ service
 - foreign: --> i want to learn English to work in foreign country.
 - experience : --> i have 6 months experience working at Bstar Solutions.
 -foreigner -->
*/
