package com.encora.starship.dao;

import com.encora.starship.model.domain.Startship;
import reactor.core.publisher.Mono;

public interface StarshipDao {

    Mono<Startship> getStarship(Integer starshipId);
    Mono<Startship> saveStarship(Startship startship);

}
