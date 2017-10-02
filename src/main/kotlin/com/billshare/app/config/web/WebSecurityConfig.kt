package com.billshare.app.config.web

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.csrf.CookieCsrfTokenRepository


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
class WebSecurityConfig: WebSecurityConfigurerAdapter() {

  @Throws(Exception::class)
  override fun configure(web: WebSecurity) {
    web.ignoring().antMatchers("/user/create", "/user/login")
  }

  @Throws(Exception::class)
  override fun configure(http: HttpSecurity) {

    // CSRF is only for browser based applications
    http.csrf()
        .disable()

    http.formLogin()
        .disable()


    // allow requests when authenticated
    http.antMatcher("/**")
        .authorizeRequests().anyRequest().authenticated()
  }

  @Bean
  @Throws(Exception::class)
  override fun authenticationManagerBean(): AuthenticationManager {
    return super.authenticationManagerBean()
  }
}