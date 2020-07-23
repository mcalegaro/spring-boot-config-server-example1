package com.example.cloudserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication(exclude = UserDetailsServiceAutoConfiguration.class)
@EnableConfigServer
public class ConfigServerApplication extends WebSecurityConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerApplication.class, args);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http

				.csrf().disable()

				.authorizeRequests()

				.antMatchers("/decrypt").authenticated()

				.and()

				.authorizeRequests().antMatchers("/**").permitAll();

	}

}
