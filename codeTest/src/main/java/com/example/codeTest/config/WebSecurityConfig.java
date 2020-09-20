package com.example.codeTest.config;

import java.util.Arrays;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.header.writers.frameoptions.WhiteListedAllowFromStrategy;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/", "/css/**", "/account/**", "/h2_db/**").permitAll()
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/account/login").permitAll()
				.and()
			.logout()
				.logoutSuccessUrl("/index").permitAll() 
				.and()
			.csrf().ignoringAntMatchers("/h2_db/**")
			.and()
            .headers()
                .addHeaderWriter(
                    new XFrameOptionsHeaderWriter(
                        new WhiteListedAllowFromStrategy(Arrays.asList("localhost"))    // 여기!
                    )
                )
                .frameOptions().sameOrigin() ;

	}

	// UserDetailsService를 User Repository에서 읽어오도록 구현하는 Bean을 등록해서 써야 함
	// 이건 테스트코드고, 시작할 때 유저를 넣어주게 됨
	/*
	 * @Bean
	 * 
	 * @Override protected UserDetailsService userDetailsService() { UserDetails
	 * user =
	 * User.withDefaultPasswordEncoder().username("user").password("1q2w3e4r").roles
	 * ("USER").build(); return new InMemoryUserDetailsManager(user); }
	 */

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
	  throws Exception {
	    auth.jdbcAuthentication()
	      .dataSource(dataSource)
	      .withDefaultSchema()
	      .withUser(User.withUsername("admin")
	        .password(passwordEncoder().encode("admin"))
	        .roles("ADMIN"));
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
}
