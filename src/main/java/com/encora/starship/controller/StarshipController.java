package com.encora.starship.controller;

import com.encora.starship.controller.client.StarshipResponse;
import com.encora.starship.mapper.StarshipMapper;
import com.encora.starship.service.StarshipService;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class StarshipController {

  StarshipService starshipService;
  StarshipMapper starshipMapper;


  @GetMapping("/starships/{starshipId}")
  @ResponseStatus(HttpStatus.OK)
  public Mono<StarshipResponse> getStarship(
          @PathVariable("starshipId")
          @Pattern(regexp="[\\d]{2}", message = "El número de cuenta debe ser de 2 dígitos")
          Integer starshipId) {
    return starshipService.getStarship(starshipId)
            .map(starshipMapper::mapStarshipResponse);
  }

  @PostMapping("/starships")
  @ResponseStatus(HttpStatus.CREATED)
  public Flux<StarshipResponse> createStarship() {
    return starshipService.getAndSaveStarships()
            .map(starshipMapper::mapStarshipResponse);
  }

}
