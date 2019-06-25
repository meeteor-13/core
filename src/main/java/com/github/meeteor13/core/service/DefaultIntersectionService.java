package com.github.meeteor13.core.service;

import com.github.meeteor13.core.domain.Intersection;
import com.github.meeteor13.core.domain.Location;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Period;

@Service
@RequiredArgsConstructor
public class DefaultIntersectionService implements IntersectionService {

    private final ReactiveMongoOperations mongoTemplate;

    @Override
    public Flux<Intersection> calculate(Period period) {
        return mongoTemplate.aggregate(
            Aggregation.newAggregation(
                //TODO add operators
            ),
            Location.class,
            Intersection.class
        );
    }
}
