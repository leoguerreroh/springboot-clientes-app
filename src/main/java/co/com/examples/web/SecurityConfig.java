package co.com.examples.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
//    
//    @Autowired
//    public void configuredGlobal(AuthenticationManagerBuilder build)throws Exception{
//        build.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//    }
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests(auth -> auth
                .requestMatchers("/editar/**", "/agregar/**", "/eliminar")
                .hasRole("ADMIN")
                .requestMatchers("/login", "/css/**", "/js/**", "/webjars/**")
                .permitAll()
                .anyRequest().authenticated()
                )
                .formLogin(form -> form
                .loginPage("/login")
                .defaultSuccessUrl("/", true)
                .permitAll()
                )
                .logout(logout -> logout
                .permitAll()
                )
                .exceptionHandling(ex -> ex
                .accessDeniedPage("/errores/403")
                );

        return http.build();
    }
    

//    @Bean
//    public UserDetailsService users() {
//
//        UserDetails admin = User.withUsername("admin")
//                .password("{noop}123")
//                .roles("ADMIN", "USER")
//                .build();
//
//        UserDetails user = User.withUsername("user")
//                .password("{noop}142")
//                .roles("USER")
//                .build();
//
//        return new InMemoryUserDetailsManager(admin, user);
//    }
}
