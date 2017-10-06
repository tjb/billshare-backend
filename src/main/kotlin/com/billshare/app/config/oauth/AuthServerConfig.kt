package com.billshare.app.config.oauth

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer

@Configuration
@EnableAuthorizationServer
class AuthServerConfig(@Value("\${billshare.oauth.tokenTimeout:3600}") var expiration: Int): AuthorizationServerConfigurerAdapter() {

  @Autowired lateinit var userDetailsService: UserDetailsService
  @Autowired lateinit var authenticationManager: AuthenticationManager


  override fun configure(configurer: AuthorizationServerEndpointsConfigurer) {
    configurer.authenticationManager(authenticationManager)
    configurer.userDetailsService(userDetailsService)
  }

  override fun configure(clients: ClientDetailsServiceConfigurer) {
    clients
        .inMemory()
        .withClient("billshare") // TODO: Set to settings in application.yml
        .accessTokenValiditySeconds(expiration)
        .scopes("read", "write")
        .authorizedGrantTypes("password", "refresh_token")
  }
}