package com.github.meeteor13.core.controller;

import com.github.meeteor13.core.domain.Location;
import com.github.meeteor13.core.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/locations")
@RequiredArgsConstructor
public class LocationController {

    private final LocationRepository locationRepository;

    @GetMapping
    public Flux<Location> findAllByUserId(@RequestParam Long userId) {
        return locationRepository.findAllByUserId(userId);
    }

    @PostMapping
    public Mono<Location> save(@RequestBody Location location) {
        return locationRepository.save(location);
    }
}
