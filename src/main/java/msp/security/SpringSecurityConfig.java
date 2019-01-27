package msp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import msp.services.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("UserDetailsService")
	UserDetailsServiceImpl userService;
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
	
//	@Bean
//    public DaoAuthenticationProvider authenticationProvider(){
//        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
//        auth.setUserDetailsService(userService);
//        auth.setPasswordEncoder(passwordEncoder());
//        return auth;
//    }


	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.csrf().disable();
        http.httpBasic();
	    http
	    .authorizeRequests().antMatchers("/registration").permitAll()
	    .and()
	    .authorizeRequests().anyRequest().authenticated();
	}

}
