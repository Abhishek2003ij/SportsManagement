package com.Infosys.SportsManagement.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.Infosys.SportsManagement.service.EventUserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
@Autowired
private EventUserService service;
@Autowired
private PasswordEncoder passwordEncoder;
@Autowired
@Override
protected void configure(AuthenticationManagerBuilder authority) throws Exception {
  authority.userDetailsService(service).passwordEncoder(passwordEncoder);
}
@Override
public void configure(HttpSecurity http) throws Exception {
 http.authorizeRequests().antMatchers("/register","/images/**").permitAll().anyRequest().authenticated().and().formLogin().loginPage("/loginpage").loginProcessingUrl("/login")
 .defaultSuccessUrl("/index", true)
 .failureUrl("/loginpage?error=true")
 .permitAll()
.and()
.logout()
 .logoutUrl("/logout")
 .logoutSuccessUrl("/loginpage")
 .permitAll()
.and()
.csrf().disable();
 }

}