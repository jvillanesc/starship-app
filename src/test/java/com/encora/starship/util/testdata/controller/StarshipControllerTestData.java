package com.encora.starship.util.testdata.controller;

import com.encora.starship.controller.client.StarshipResponse;
import com.encora.starship.model.domain.Startship;

public class StarshipControllerTestData {
    public static Startship getStarship() {
        return Startship.builder()
                .starshipId(1)
                .name("Death Star")
                .model("DS-1 Orbital Battle Station")
                .manufacturer("Imperial Department of Military Research, Sienar Fleet Systems")
                .build();
    }

    public static StarshipResponse getStarshipResponse() {
        return StarshipResponse.builder()
                .starshipId(1)
                .name("Death Star")
                .model("DS-1 Orbital Battle Station")
                .manufacturer("Imperial Department of Military Research, Sienar Fleet Systems")
                .build();
    }

}
