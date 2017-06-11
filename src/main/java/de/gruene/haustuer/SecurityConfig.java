package de.gruene.haustuer;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

/**
 * Created by @atamanroman on 05.06.17.
 */
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication()
      .withUser("user1").password("password1").roles("USER").and()
      .withUser("user2").password("password2").roles("USER").and()
      .withUser("admin").password("admin").roles("ACTUATOR", "USER");
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
      .csrf().disable()
      .httpBasic()
      // no www-authenticate header -> no prompt in browser
      .authenticationEntryPoint(new BasicAuthenticationEntryPoint() {
        @Override
        public void commence(HttpServletRequest request, HttpServletResponse response,
          AuthenticationException authException) throws IOException, ServletException {
          response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
            authException.getMessage());
        }

        @Override
        public void afterPropertiesSet() throws Exception {
          // dont throw :)
        }
      })
      .and()
      .authorizeRequests()
      .antMatchers("/user/**").permitAll()
      .antMatchers("/docs/**").permitAll()
      .antMatchers("/v2/api-docs", "/swagger/**").permitAll()
      .anyRequest().hasRole("USER");
  }
}
