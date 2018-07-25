package com.webfluxcrud.heroes.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.webfluxcrud.heroes.entity.Heroes;

import reactor.core.publisher.Flux;

public interface HeroRepository extends ReactiveMongoRepository<Heroes, Integer> {

    Flux<Heroes> findByName(String name);

}
