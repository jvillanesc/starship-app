package com.encora.starship.service;

import com.encora.starship.dao.StarshipDao;
import com.encora.starship.dao.VehicleDao;
import com.encora.starship.exception.BussinesException;
import com.encora.starship.exception.enums.BussinesErrorEnum;
import com.encora.starship.mapper.StarshipMapper;
import com.encora.starship.model.domain.Startship;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.LocalDateTime;

public interface StarshipService {

  Flux<Startship> getAndSaveStarships();

  Mono<Startship> getStarship(Integer starshipId);

}
