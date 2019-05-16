package io.jtools.totp.config;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.warrenstrange.googleauth.GoogleAuthenticator;
import com.warrenstrange.googleauth.IGoogleAuthenticator;

import io.jtools.totp.dpAccountUserdepts.service.DpAccountUsersdeptsService;
import io.jtools.totp.dpAccountUsers.service.DpAccountUsersService;
import io.jtools.totp.hrEmployee.service.HrEmployeeService;
import io.jtools.totp.util.security.ExtensibleAuthenticationFailureHandler;
import io.jtools.totp.util.security.ExtensibleUserDetailsAuthenticationProvider;
import io.jtools.totp.util.security.TOTPWebAuthenticationDetailsSource;
import io.jtools.util.PasswordInit;

/**
 * Spring Security Configuration
 * @author KHJ
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter implements Serializable{
	private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;
	public static final String JSESSIONID = "JSESSIONID";
	
    @Autowired
    UserDetailsService userDetailsService;
    
    @Autowired
    DpAccountUsersdeptsService dpAccountUsersdeptsService;
    
    @Autowired
    DpAccountUsersService dpAccountUsersService;

    @Autowired
    HrEmployeeService hrEmployeeService;
    
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	IGoogleAuthenticator googleAuthenticator() {
		return new GoogleAuthenticator();
	}
	
	@Bean
	PasswordInit passwordInit(){
		return new PasswordInit();
	}
	
	/**
	 * 스프링 시큐리티 설정을 무시하도록 하는 설정
	 */
	@Override
	public void configure(WebSecurity web) throws Exception {
		web
		.ignoring()
		.antMatchers("/webjars/**")
		.antMatchers("/css/**")
		.antMatchers("/img/**")
		.antMatchers("/js/**")
		.antMatchers("/bower_components/**")
		;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	     http
         .authorizeRequests()
         .antMatchers("/user/add").permitAll()
         .antMatchers("/logout").permitAll()
         .antMatchers(HttpMethod.GET, "/login").permitAll()
         .anyRequest().fullyAuthenticated()
         .and()
         .formLogin().authenticationDetailsSource(new TOTPWebAuthenticationDetailsSource())
         .loginPage("/login")
         .defaultSuccessUrl("/index")
         .failureUrl("/login?error").failureHandler(new ExtensibleAuthenticationFailureHandler()).permitAll()
         .and()
         .logout()
         .logoutSuccessUrl("/login?logout")
         .deleteCookies(JSESSIONID).permitAll()
         .and()
         	.headers().frameOptions().disable()
         .and()
         	.csrf().disable();
	     
	}
	
	@Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .authenticationProvider(authenticationProvider())
                .inMemoryAuthentication()
                .withUser("user").password("user").roles("USER");
    }
	
	@Bean
    AuthenticationProvider authenticationProvider() {
        ExtensibleUserDetailsAuthenticationProvider authenticationProvider = new ExtensibleUserDetailsAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        authenticationProvider.setUserDetailsService(this.userDetailsService);
        authenticationProvider.setDpAccountUsersService(this.dpAccountUsersService);
        authenticationProvider.setDpAccountUsersdeptsService(this.dpAccountUsersdeptsService);
        authenticationProvider.setHrEmployeeService(this.hrEmployeeService);
        authenticationProvider.setAuthenticator(googleAuthenticator());
        return authenticationProvider;
    }
}
