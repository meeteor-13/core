package com.github.meeteor13.core.configuration;

import com.github.meeteor13.core.converter.LibraryUserRolesJwtAuthenticationConverter;
import org.springframework.boot.autoconfigure.security.reactive.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
public class WebSecurityConfiguration {

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        http.csrf().disable();

        http.authorizeExchange()
            .matchers(PathRequest.toStaticResources().atCommonLocations())
            .permitAll();

        // or here
        http.authorizeExchange()
//            .pathMatchers(HttpMethod.GET, "/products/**").hasRole("PRODUCTS_READ")
            .anyExchange().authenticated();

        http.oauth2ResourceServer()
            .jwt()
            .jwtAuthenticationConverter(libraryUserRolesJwtAuthenticationConverter());

        return http.build();
    }

    @Bean
    public LibraryUserRolesJwtAuthenticationConverter libraryUserRolesJwtAuthenticationConverter() {
        return new LibraryUserRolesJwtAuthenticationConverter();
    }
}
