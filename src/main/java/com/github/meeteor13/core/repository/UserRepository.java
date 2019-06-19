package com.github.meeteor13.core.repository;

import com.github.meeteor13.core.domain.User;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;


@Repository
public interface UserRepository extends ReactiveMongoRepository<User, String> {
}
