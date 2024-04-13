package com.encora.starship.controller;

import com.encora.starship.mapper.StarshipMapperImpl;
import com.encora.starship.util.testdata.controller.StarshipControllerTestData;
import com.encora.starship.controller.client.StarshipResponse;
import com.encora.starship.model.domain.Startship;
import com.encora.starship.service.StarshipService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.reactive.server.FluxExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;
import static org.mockito.Mockito.when;


@WebFluxTest
@ContextConfiguration(classes = {
        StarshipController.class,
        StarshipMapperImpl.class
    })
class StarshipControllerTest {

  @MockBean
  private StarshipService starshipService;

  @Autowired
  private WebTestClient webTestClient;

  @Test
  @DisplayName("succesfullCreateStarships")
  void succesfullCreateStarships() {

    //Arrange
    Startship startshipCreated = StarshipControllerTestData.getStarship();
    when(starshipService
        .getAndSaveStarships())
        .thenReturn(Flux.just(startshipCreated));

    //Arrange
    FluxExchangeResult<StarshipResponse> result =  webTestClient.post()
        .uri("/api/starships")
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON)
        .exchange()
        .expectStatus().isCreated()
        .returnResult(StarshipResponse.class);

    //Assert
    StepVerifier.create(result.getResponseBody())
        .expectNext(StarshipControllerTestData.getStarshipResponse())
        .expectNextCount(0)
        .thenCancel()
        .verify();
  }

}