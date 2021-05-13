package com.iunis.adventclub.config;

import com.iunis.adventclub.service.UsuarioDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    //necesario para evitar qe se aplique seguridad a los recursos
    String[] resourses = new String[]{"/build/**", "/dist/**", "/docs/**", "/pages/**", "/plugins/**"};

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .authorizeRequests()
                .antMatchers(resourses).permitAll()
                .antMatchers("/adventClub").permitAll()
                .antMatchers("/inscripcionForm").permitAll()
                .antMatchers("/getPDF").permitAll()
                .antMatchers("/reimpresion").permitAll()
                .antMatchers("/","/index").permitAll()
                .antMatchers("/admin**").access("hasRole('ADMIN')")
                .antMatchers("/user**").access("hasRole('USER') or hasRole('ADMIN')")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .defaultSuccessUrl("/dashboard")
                .failureUrl("/login?error=true")
                .usernameParameter("username")
                .passwordParameter("password")
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/")
                .permitAll();
    }

    BCryptPasswordEncoder passwordEncoder;

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        passwordEncoder = new BCryptPasswordEncoder(4);

        return passwordEncoder;
    }

    @Autowired
    UsuarioDetailsServiceImpl usuarioDetailsService;

    @Autowired
    public void ConfigureGlobar(AuthenticationManagerBuilder managerBuilder) throws Exception{
        managerBuilder.userDetailsService(usuarioDetailsService).passwordEncoder(passwordEncoder());
    }
}
