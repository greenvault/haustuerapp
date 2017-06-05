package de.gruene.haustuer;

import org.hibernate.engine.jdbc.connections.internal.DatasourceConnectionProviderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.builders.JdbcClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

import javax.sql.DataSource;

/**
 * Created by @atamanroman on 05.06.17.
 */
@EnableWebSecurity
@Configuration
@EnableResourceServer
@EnableAuthorizationServer
public class SecurityConfig /* extends WebSecurityConfigurerAdapter */ {

  @Autowired
  DataSource ds;

  @Autowired
  public PasswordEncoder passwordEncoder;

  @Bean
  public PasswordEncoder bcryptPasswordEncoder() {
    return new BCryptPasswordEncoder();
  }
//
//  @Override
//  protected void configure(HttpSecurity http) throws Exception {
//    http.csrf().disable()
//      .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
//      .authorizeRequests()
//      .antMatchers("/user/**").permitAll()
//      .antMatchers("/docs/**").permitAll()
//      .anyRequest().hasRole("USER");
//  }



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
