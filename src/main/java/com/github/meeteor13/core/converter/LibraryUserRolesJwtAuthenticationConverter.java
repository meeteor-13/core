package com.github.meeteor13.core.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import reactor.core.publisher.Mono;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

// It can be in third party meeteor library in future,
// when there will be much more services
// Thanks spring a lot
public class LibraryUserRolesJwtAuthenticationConverter
    implements Converter<Jwt, Mono<AbstractAuthenticationToken>> {

    // constant
    private static final String RESOURCE_ACCESS_CLAIMS = "resource_access";

    // spring application name, so from @Value
    private static final String RESOURCE_ID = "core";

    // Thanks spring one more time
    private static final String ROLE_PREFIX = "ROLE_";

    // i know
    private static final String RESOURCE_ROLES_KEY = "roles";

    @Override
    public Mono<AbstractAuthenticationToken> convert(final Jwt source) {
        final Collection<GrantedAuthority> authorities = extractAuthorities(source);

        final UsernamePasswordAuthenticationToken authenticationToken =
            new UsernamePasswordAuthenticationToken(source.getSubject(), "n/a", authorities);

        return Mono.just(authenticationToken);
    }

    private Collection<GrantedAuthority> extractAuthorities(final Jwt source) {
        return this.getRolesFromResourceAccess(source).stream()
            .map(authority -> ROLE_PREFIX + authority.toUpperCase(Locale.getDefault()))
            .map(SimpleGrantedAuthority::new)
            .collect(Collectors.toList());
    }

    @NotNull
    private List<String> getRolesFromResourceAccess(final Jwt source) {
        final ObjectMapper objectMapper = new ObjectMapper();
        LinkedHashMap<String, List<String>> resourceRoles = new LinkedHashMap<>();
        try {
            resourceRoles = (LinkedHashMap<String, List<String>>)
                objectMapper
                    .readValue(source.getClaimAsString(RESOURCE_ACCESS_CLAIMS), Map.class)
                    .get(RESOURCE_ID);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return resourceRoles.get(RESOURCE_ROLES_KEY);
    }
}
