package com.encora.starship.repository;

import com.encora.starship.repository.entity.StarshipEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StarshipRepository extends R2dbcRepository<StarshipEntity, Integer>{


}
