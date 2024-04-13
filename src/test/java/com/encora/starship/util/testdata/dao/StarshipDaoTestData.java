package com.encora.starship.util.testdata.dao;

import com.encora.starship.model.domain.Startship;
import com.encora.starship.repository.entity.StarshipEntity;

public class StarshipDaoTestData {
    public static StarshipEntity getStarshipEntity() {
        return StarshipEntity.builder()
                .starshipId(1)
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
