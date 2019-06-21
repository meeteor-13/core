package com.github.meeteor13.core.repository;

import com.github.meeteor13.core.domain.Intersection;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface IntersectionRepository extends ReactiveMongoRepository<Intersection, String> {
    Flux<Intersection> findAllByUsersContains(Long userId);
}
