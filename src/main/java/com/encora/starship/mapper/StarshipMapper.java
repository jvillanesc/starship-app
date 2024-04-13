package com.encora.starship.mapper;

import com.encora.starship.model.domain.Startship;
import com.encora.starship.repository.entity.StarshipEntity;
import com.encora.starship.controller.client.StarshipResponse;
import com.encora.starship.thirdparty.client.SwapiVehicle;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StarshipMapper {

    Startship mapStartship(SwapiVehicle swapiVehicle);

    StarshipEntity mapStarshipEntity(Startship startship);

    Startship mapStartship(StarshipEntity starshipEntity);

    StarshipResponse mapStarshipResponse(Startship startship);

}
