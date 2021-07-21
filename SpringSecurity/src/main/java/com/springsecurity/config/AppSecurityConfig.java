package com.springsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

//@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
//@EnableOAuth2Sso
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;
	
	/**
	 * Configurations required when we are using Credentials from H2 Database For Authentication
	 * @return
	 */
	@Bean
	public AuthenticationProvider authProvider() {
		System.out.println("Entered Authentication Provider");
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();//Communicates with our DataBase
		provider.setUserDetailsService(userDetailsService);//We should have a service. ( Controller -> Service -> Dao )
		provider.setPasswordEncoder(new BCryptPasswordEncoder(10));
		
		return provider;
	}
	
	

	/**
	 * Configurations for having login/logout page.
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		/**
		 * Configuration Required when we are using OAuth2
		 */
		/*http
			.csrf().disable()
			.authorizeRequests().antMatchers("/login").permitAll()
			.anyRequest().authenticated();
		*/
		
		/**
		 * Configurations required when we are using our own login Portal for Authentication
		 */ 
		  http
			.csrf().disable()
			.authorizeRequests().antMatchers("/login").permitAll()
			.anyRequest().authenticated()
			.and()
			.formLogin()
			.loginPage("/login").permitAll()
			.and()
			.logout().invalidateHttpSession(true)
			.clearAuthentication(true)
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/logout-success").permitAll();
			
	}
	
	
/**	
 * Only required if we are using HardCoded Username/Password
 */
 /* @Bean
	@Override
	protected UserDetailsService userDetailsService() {
		
		List<UserDetails> users = new ArrayList<>();
		users.add(User.withDefaultPasswordEncoder().username("Roy").password("password").roles("USER").build());

		return new InMemoryUserDetailsManager(users);
	}
*/
	
}
