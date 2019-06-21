package com.github.meeteor13.core.controller;

import com.github.meeteor13.core.domain.User;
import com.github.meeteor13.core.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/{id}")
    public Mono<User> findById(@PathVariable("id") String id) {
        return userRepository.findById(id);
    }

    @PostMapping
    public Mono<User> saveUser(@RequestBody User user) {
        return Mono.justOrEmpty(user)
            .map(User::getId)
            .flatMap(userRepository::findById)
            .map(foundUser -> User.builder()
                .id(user.getId())
                .locations(Stream.of(user.getLocations(), foundUser.getLocations())
                    .flatMap(Collection::stream)
                    .distinct()
                    .collect(Collectors.toList()))
                .build())
            .defaultIfEmpty(user)
            .flatMap(userRepository::save);
    }
}
