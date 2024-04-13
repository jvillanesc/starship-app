package com.encora.starship.service.impl;

import com.encora.starship.dao.StarshipDao;
import com.encora.starship.dao.VehicleDao;
import com.encora.starship.exception.BussinesException;
import com.encora.starship.exception.enums.BussinesErrorEnum;
import com.encora.starship.mapper.StarshipMapper;
import com.encora.starship.model.domain.Startship;
import com.encora.starship.service.StarshipService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.LocalDateTime;

@Service
@Slf4j
@AllArgsConstructor
public class StarshipServiceImpl implements StarshipService {

  StarshipDao starshipDao;
  VehicleDao vehicleDao;
  StarshipMapper starshipMapper;

  public Flux<Startship> getAndSaveStarships() {
    log.info("Get and save startships");
    return vehicleDao.getStarships()
                      .flatMap(starship -> starshipDao.saveStarship(
                              starshipMapper.mapStartship(starship)
                                .mutate()
                                .publishDate(LocalDateTime.now())
                                .build()
                              )
                      );
  }

  public Mono<Startship> getStarship(Integer starshipId) {
    log.info("Get Starship {}", starshipId);
    return starshipDao.getStarship(starshipId)
            .switchIfEmpty(Mono.error(new BussinesException(BussinesErrorEnum.STARSHIP_NOT_EXIST)))
            .map(this::evaluateExpiration);
  }

  private Startship evaluateExpiration(Startship startship){
    Long duration = Duration.between(startship.getPublishDate(), LocalDateTime.now()).toSeconds();
    log.info("duration {}", duration);
    if (duration > 20) {
      throw new BussinesException(BussinesErrorEnum.STARSHIP_EXPIRED);
    }
    return startship;
  }
}
