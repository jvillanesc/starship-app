package com.encora.starship.dao.impl;

import com.encora.starship.dao.StarshipDao;
import com.encora.starship.mapper.StarshipMapper;
import com.encora.starship.model.domain.Startship;
import com.encora.starship.repository.StarshipRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Slf4j
@Component
@AllArgsConstructor
public class StarshipDaoImpl implements StarshipDao {

    StarshipRepository starshipRepository;
    StarshipMapper starshipMapper;

    @Override
    public Mono<Startship> getStarship(Integer starshipId) {
        return starshipRepository.findById(starshipId)
                .map(starshipMapper::mapStartship)
                .doOnError(error -> log.error("Error getStarship {}", error.getMessage()));
    }


    @Override
    public Mono<Startship> saveStarship(Startship startship) {
        return Mono.fromCallable(() -> starshipMapper.mapStarshipEntity(startship))
                .flatMap(starshipRepository::save)
                        .map(starshipMapper::mapStartship)
                .doOnError(error -> log.error("Error save startship {}", error.getMessage()));
    }


}
