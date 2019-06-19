package com.github.meeteor13.core.repository;

import com.github.meeteor13.core.domain.Intersection;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface IntersectionRepository extends ReactiveMongoRepository<Intersection, String> {
}
