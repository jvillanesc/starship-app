package com.encora.starship.dao;

import com.encora.starship.thirdparty.client.SwapiVehicle;
import reactor.core.publisher.Flux;

public interface VehicleDao {

    Flux<SwapiVehicle> getStarships();

}
