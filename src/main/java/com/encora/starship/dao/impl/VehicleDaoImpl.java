package com.encora.starship.dao.impl;

import com.encora.starship.dao.VehicleDao;
import com.encora.starship.thirdparty.SwapiClient;
import com.encora.starship.thirdparty.client.SwapiVehicle;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Component
@Slf4j
@AllArgsConstructor
public class VehicleDaoImpl implements VehicleDao {

    SwapiClient starshipClient;

    @Override
    public Flux<SwapiVehicle> getStarships() {
        return starshipClient.getVehicles()
                .flatMapIterable(starshipServiceClientResponse -> starshipServiceClientResponse.getResults())
                .delayElements(Duration.ofSeconds(1))
                .log();
    }


}
