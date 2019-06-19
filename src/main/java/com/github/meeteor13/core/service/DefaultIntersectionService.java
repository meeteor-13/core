package com.github.meeteor13.core.service;

import com.github.meeteor13.core.domain.Intersection;
import com.github.meeteor13.core.domain.User;
import com.github.meeteor13.core.repository.IntersectionRepository;
import com.github.meeteor13.core.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Period;

@Service
@RequiredArgsConstructor
public class DefaultIntersectionService implements IntersectionService {

    private final UserRepository userRepository;
    private final IntersectionRepository intersectionRepository;
    private final ReactiveMongoOperations mongoTemplate;

    @Scheduled(cron = "${application.services.intersection.cron}")
    public void run() {
        final Flux<Intersection> intersections = calculate(Period.ofDays(3));
        intersectionRepository.saveAll(intersections);
    }

    @Override
    public Flux<Intersection> calculate(Period period) {
        return mongoTemplate.aggregate(
            Aggregation.newAggregation(
                //TODO add operators
            ),
            User.class,
            Intersection.class
        );
    }
}
