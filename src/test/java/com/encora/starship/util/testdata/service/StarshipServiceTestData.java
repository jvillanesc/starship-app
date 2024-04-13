package com.encora.starship.util.testdata.service;

import com.encora.starship.model.domain.Startship;
import com.encora.starship.thirdparty.client.SwapiVehicle;

public class StarshipServiceTestData {


    public static SwapiVehicle getStarshipDetail() {
        return SwapiVehicle.builder()
                .name("Death Star")
                .model("DS-1 Orbital Battle Station")
                .manufacturer("Imperial Department of Military Research, Sienar Fleet Systems")
                .build();
    }

    public static Startship getStarship() {
        return Startship.builder()
                .starshipId(1)
                .name("Death Star")
                .model("DS-1 Orbital Battle Station")
                .manufacturer("Imperial Department of Military Research, Sienar Fleet Systems")
                .build();
    }


}
