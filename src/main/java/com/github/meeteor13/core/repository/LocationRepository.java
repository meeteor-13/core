package com.github.meeteor13.core.repository;

import com.github.meeteor13.core.domain.Location;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;


@Repository
public interface LocationRepository extends ReactiveMongoRepository<Location, String> {
    Flux<Location> findAllByUserId(Long userId);
}
