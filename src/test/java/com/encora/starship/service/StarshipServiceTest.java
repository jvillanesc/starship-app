package com.encora.starship.service;

import com.encora.starship.dao.StarshipDao;
import com.encora.starship.dao.VehicleDao;
import com.encora.starship.mapper.StarshipMapper;
import com.encora.starship.model.domain.Startship;
import com.encora.starship.util.testdata.service.StarshipServiceTestData;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
@ExtendWith({MockitoExtension.class})
class StarshipServiceTest {

    @Mock
    private StarshipDao starshipDao;

    @Mock
    private VehicleDao vehicleDao;

    @Spy
    private StarshipMapper starshipMapper = Mappers.getMapper(StarshipMapper.class);

    @InjectMocks
    private StarshipService starshipService;

    @Test
    @DisplayName("succesfullCreateStarships")
    void succesfullCreateStarships() {

        //Arrange
        Mockito.when(vehicleDao.getStarships())
                .thenReturn(Flux.just(StarshipServiceTestData.getStarshipDetail()));
        Startship startship = StarshipServiceTestData.getStarship();
        Mockito.when(starshipDao.saveStarship(Mockito.any()))
                .thenReturn(Mono.just(startship));

        //Act
        Flux<Startship> mono = starshipService.getAndSaveStarships();

        //Assert
        StepVerifier.create(mono)
                    .assertNext(starship -> Assertions.assertThat(starship.getStarshipId()).isEqualTo(startship.getStarshipId()))
                    .verifyComplete();
    }


}
