package com.example.productfist.config;

import com.example.productfist.filter.CustomerAuthenticationFilter;
import com.example.productfist.filter.CustomerAuthorizationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.http.HttpMethod.POST;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CustomerAuthenticationFilter customAuthenticationFilter = new CustomerAuthenticationFilter(authenticationManagerBear());
        customAuthenticationFilter.setFilterProcessesUrl("/api/login");
        http.csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/api/login/**", "/api/register/**").permitAll()
                .antMatchers(HttpMethod.GET, "/api/Users/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_USER", "ROLE_SUPER_ADMIN")
                .antMatchers(POST, "/api/user/save/**").hasAnyRole("ROLE_ADMIN", "ROLE_SUPER_ADMIN")
                .antMatchers(HttpMethod.PUT, "/api/user/edit/**").hasAnyRole("ROLE_ADMIN", "ROLE_SUPER_ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/user/delete/**").hasAnyRole("ROLE_SUPER_ADMIN")
                .anyRequest().authenticated();

        http.addFilter(customAuthenticationFilter);
        http.addFilterBefore(new CustomerAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);

    }

    @Bean
    public AuthenticationManager authenticationManagerBear() throws Exception {
        return super.authenticationManagerBean();
    }
}
