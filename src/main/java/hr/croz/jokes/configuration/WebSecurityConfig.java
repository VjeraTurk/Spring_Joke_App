package hr.croz.jokes.configuration;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
            .logout()
                .permitAll();
    }

    //username: pperic, password: pero
    // username: iivic, password: ivan
    @Bean
    @Override
    public UserDetailsService userDetailsService() {
    	
    	//Using this method is not considered safe for production, but is acceptable for demos and getting started. For production purposes, ensure the password is encoded externally. 
        //https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/core/userdetails/User.html
    	@SuppressWarnings("deprecation")
		UserDetails pero =
             User.withDefaultPasswordEncoder()
                .username("pperic")
                .password("pero")
                .roles("USER")
                .build();

    	@SuppressWarnings("deprecation")
		UserDetails ivo =
             User.withDefaultPasswordEncoder()
                .username("iivic")
                .password("ivo")
                .roles("USER")
                .build();
    	
    	Collection<UserDetails> users = new ArrayList<UserDetails>();
    	users.add(pero);
    	users.add(ivo);
        return new InMemoryUserDetailsManager(users);
  
    }
}