package com.github.meeteor13.core.converter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import reactor.core.publisher.Mono;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

// It can be in third party meeteor library in future,
// when there will be much more services
// Thanks spring a lot
@Slf4j
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
        final Collection<GrantedAuthority> authorities = Optional
            .ofNullable(source.getClaimAsMap(RESOURCE_ACCESS_CLAIMS))
            .map(it -> ((Map<String, List<String>>) it.get(RESOURCE_ID)))
            .map(it -> it.get(RESOURCE_ROLES_KEY))
            .orElseGet(Collections::emptyList)
            .stream()
            .map(a -> String.format("%s%s", ROLE_PREFIX, a.toUpperCase(Locale.getDefault())))
            .map(SimpleGrantedAuthority::new)
            .collect(Collectors.toList());

        final UsernamePasswordAuthenticationToken authenticationToken =
            new UsernamePasswordAuthenticationToken(source.getSubject(), "n/a", authorities);

        return Mono.just(authenticationToken);
    }
}
