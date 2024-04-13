package com.encora.starship.repository.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@Table("startship")
public class StarshipEntity {

  @Id
  @Column("startship_id")
  private Integer starshipId;
  @Column("name")
  private String name;
  @Column("model")
  private String model;
  @Column("manufacturer")
  private String manufacturer;
  @Column("publish_date")
  private LocalDateTime publishDate;

}
