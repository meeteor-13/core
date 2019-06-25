package com.github.meeteor13.core.job;

import com.github.meeteor13.core.domain.Intersection;
import com.github.meeteor13.core.repository.IntersectionRepository;
import com.github.meeteor13.core.service.IntersectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Period;

@Component
@RequiredArgsConstructor
public class IntersectionJob {

    private final IntersectionRepository repository;
    private final IntersectionService service;

    @Scheduled(cron = "${application.jobs.intersection.cron}")
    public void run() {
        final Flux<Intersection> intersections = service.calculate(Period.ofDays(3));
        repository.saveAll(intersections);
    }
}
