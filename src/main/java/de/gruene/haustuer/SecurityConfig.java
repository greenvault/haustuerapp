package de.gruene.haustuer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * Created by @atamanroman on 05.06.17.
 */
@EnableWebSecurity
@Configuration
@EnableResourceServer
public class SecurityConfig {

  @Bean
  public ResourceServerConfigurer resourceServerConfigurer() {
    return new ResourceServerConfigurer() {
      @Override
      public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
      }

      @Override
      public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
          .authorizeRequests()
          .antMatchers("/user/**").permitAll()
          .antMatchers("/docs/**").permitAll()
          .anyRequest().hasRole("USER");
      }
    };
  }
}
