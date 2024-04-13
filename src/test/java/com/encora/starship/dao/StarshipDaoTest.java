package com.encora.starship.dao;

import com.encora.starship.dao.impl.StarshipDaoImpl;
import com.encora.starship.model.domain.Startship;
import com.encora.starship.repository.StarshipRepository;
import com.encora.starship.mapper.StarshipMapper;
import com.encora.starship.util.testdata.dao.StarshipDaoTestData;
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
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
@ExtendWith({MockitoExtension.class})
class StarshipDaoTest {

    @Mock
    private StarshipRepository starshipRepository;

    @Spy
    private StarshipMapper starshipMapper = Mappers.getMapper(StarshipMapper.class);

    @InjectMocks
    private StarshipDaoImpl starshipDao;

    @Test
    @DisplayName("succesfullCreateStarships")
    void succesfullCreateStarships() {

        //Arrange
        Mockito.when(starshipRepository.save(Mockito.any()))
                .thenReturn(Mono.just(StarshipDaoTestData.getStarshipEntity()));
        Startship newStartship = StarshipDaoTestData.getStarship();

        //Act
        Mono<Startship> mono = starshipDao.saveStarship(newStartship);

        //Assert
        StepVerifier.create(mono)
                    .assertNext(startship -> Assertions.assertThat(startship.getStarshipId()).isEqualTo(newStartship.getStarshipId()))
                    .verifyComplete();
    }


}
