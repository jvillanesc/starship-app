package com.encora.starship.controller.client;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class StarshipResponse {

  private Integer starshipId;
  private String name;
  private String model;
  private String manufacturer;
  @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
  private LocalDateTime publishDate;

}
