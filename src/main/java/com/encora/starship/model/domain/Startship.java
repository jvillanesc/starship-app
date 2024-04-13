package com.encora.starship.model.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class Startship {

  private Integer starshipId;
  private String name;
  private String model;
  private String manufacturer;
  private LocalDateTime publishDate;

  public StartshipBuilder mutate() {
    return Startship.builder()
            .name(name)
            .model(model)
            .manufacturer(manufacturer)
            .publishDate(publishDate);
  }

}
