package msp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import msp.services.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private AuthenticationEntryPoint authEntryPoint;
	
	@Autowired
	@Qualifier("UserDetailsService")
	UserDetailsServiceImpl userService;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

	    http.authorizeRequests()
	    //.antMatchers("/registration").permitAll()
	    .antMatchers(HttpMethod.POST).permitAll()
		.anyRequest().authenticated()
		.and().formLogin()
		.loginPage("/login").permitAll()
		.and().exceptionHandling().accessDeniedPage("/403")
		.and().httpBasic()
		.authenticationEntryPoint(authEntryPoint);
	}

}
