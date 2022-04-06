package ru.learnup.operasales.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/v1/playbill/get/**").hasAnyRole("ADMIN", "USER")
                .antMatchers(HttpMethod.POST,"/api/v1/playbill/create/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/api/v1/playbill/update/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/v1/playbill/delete/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/h2-console/**").not().authenticated()
                .antMatchers("/**").permitAll()
                .and()
                .httpBasic();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}