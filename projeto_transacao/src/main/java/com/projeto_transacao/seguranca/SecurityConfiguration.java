package com.projeto_transacao.seguranca;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests(authorizeRequests ->
                authorizeRequests
                        .antMatchers(HttpMethod.DELETE, "/api/cartoes/**").hasAuthority("SCOPE_JWT")
                        .antMatchers(HttpMethod.POST, "/api/cartoes/**").hasAuthority("SCOPE_JWT")
                        .antMatchers(HttpMethod.GET, "/transacao/**").hasAuthority("SCOPE_JWT")
                        .antMatchers(HttpMethod.DELETE, "/transacao/**").hasAuthority("SCOPE_JWT")
                        .antMatchers(HttpMethod.POST, "/transacao/**").hasAuthority("SCOPE_JWT")
                        .anyRequest().authenticated()
        )
                .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
    }
}
